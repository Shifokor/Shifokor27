package com.example.shifokor27.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shifokor27.R

class TibiyHujjatlarFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val pdfList = listOf(
        "Tahlil natijasi.pdf",
        "Rentgen rasmi.pdf",
        "MRI hisobot.pdf"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tibiy_hujjatlar, container, false)
        recyclerView = view.findViewById(R.id.rvPdf)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = PdfAdapter(pdfList)
        return view
    }

    inner class PdfAdapter(private val items: List<String>) :
        RecyclerView.Adapter<PdfAdapter.PdfViewHolder>() {

        inner class PdfViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvTitle: TextView = view.findViewById(R.id.tvTitle)
            val btnView: Button = view.findViewById(R.id.btnView)
            val btnDownload: Button = view.findViewById(R.id.btnDownload)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PdfViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pdf, parent, false)
            return PdfViewHolder(view)
        }

        override fun onBindViewHolder(holder: PdfViewHolder, position: Int) {
            val pdfName = items[position]
            holder.tvTitle.text = pdfName

            holder.btnView.setOnClickListener {
                // Faqat misol uchun - siz real PDF faylga yo‘naltirishingiz mumkin
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setDataAndType(Uri.parse("https://example.com/$pdfName"), "application/pdf")
                intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
                startActivity(intent)
            }

            holder.btnDownload.setOnClickListener {
                // Bu yerda yuklab olish funksiyasini qo‘shishingiz mumkin
                // Toast yoki progress bar bilan yuklab olayotgani ko‘rsatiladi
            }
        }

        override fun getItemCount(): Int = items.size
    }
}