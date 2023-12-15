package com.sample.demo.ui

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sample.demo.databinding.FragmentTemplateBinding
import com.sample.demo.utility.hideView
import com.sample.demo.utility.showView
import com.sample.demo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.util.Calendar


@AndroidEntryPoint
class TemplateFragment : Fragment() {
    private var _templateFragmentBinding: FragmentTemplateBinding? = null
    private val binding get() = _templateFragmentBinding!!

    private val mainViewModel: MainViewModel by viewModels()

    private var param1: String? = null
    private var startCamera: ActivityResultLauncher<Intent>? = null
    private var camUri: Uri? = null

    companion object {
        private const val arg1 = "arg1"
        @JvmStatic
        fun newInstance(param1: String) =
            TemplateFragment().apply {
                arguments = Bundle().apply {
                    putString(arg1, param1)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(arg1)
        }
        mainViewModel.getProducts()
        startCamera = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                camUri?.let {
                    binding.ivImage.setImageURI(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _templateFragmentBinding = FragmentTemplateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        processCamera()
        formSection()
        fileManager()
    }

    private fun fileManager() {
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                val path = Environment.getExternalStorageDirectory().path
                val file = File(path).listFiles()
                file?.forEach {
                    showToast(it.name)
                }
                if (file != null) {
                    file.firstOrNull()?.let {
                        context?.let { it1 ->
                            startActivity(Intent(Intent.ACTION_VIEW).setData(FileProvider.getUriForFile(
                                it1,"com.sample.demo.file-provider", it
                            )).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION))
                        }
                    }
                }
            } else {
                showToast("camera permission needed")
            }
        }
        requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    private fun processCamera() {
        checkCameraPermission()
    }

    private fun checkCameraPermission() {
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                binding.ivImage.setOnClickListener {
                    captureImageFromCamera()
                }
            } else {
                showToast("camera permission needed")
            }
        }
        requestPermissionLauncher.launch(Manifest.permission.CAMERA)
    }

    private fun captureImageFromCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From Camera")
        camUri = requireContext().contentResolver.insert(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values
        )
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, camUri)
        startCamera?.launch(cameraIntent)
    }


    private fun formSection() {
        with(binding){
            etName.doOnTextChanged { text, start, before, count ->
                showToast(text.toString())
            }

            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            datepicker.init(year,month,day){ datePicker: DatePicker, year: Int, month: Int, day: Int ->
                showToast("got date")
                datePicker.hideView()
            }
            tvChooseDate.setOnClickListener {
                datepicker.showView()
            }

            actChooseName.setAdapter(
                ArrayAdapter(
                    actChooseName.context, androidx.appcompat.R.layout.select_dialog_item_material,
                    arrayOf("saran", "manoj", "arun", "santhosh")
                )
            )
        }
    }

    private fun showToast(s: String?) {
        Toast.makeText(context, s.orEmpty(), Toast.LENGTH_SHORT).show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _templateFragmentBinding = null
    }
}