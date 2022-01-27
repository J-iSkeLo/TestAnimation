package com.example.uitesttask

import android.content.Context
import android.view.View
import android.widget.Toast

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun String.toast(context : Context) = Toast.makeText(context, this, Toast.LENGTH_SHORT).show()