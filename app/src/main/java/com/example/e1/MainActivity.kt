package com.example.e1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editCarPrice = findViewById<EditText>(R.id.editTextCarPrice)
        val editDownPayment = findViewById<EditText>(R.id.editTextDownPayment)
        val editLoanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        val editInterestRate = findViewById<EditText>(R.id.editTextInterestRate)

        val viewLoan = findViewById<TextView>(R.id.textViewLoan)
        val viewInterest = findViewById<TextView>(R.id.textViewInterest)
        val viewMonthlyRepayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)
        val decimal = DecimalFormat("00.00")

        val buttonForCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonForReset = findViewById<Button>(R.id.buttonReset)

        buttonForCalculate.setOnClickListener(View.OnClickListener
        {
            val messageCarPrice: String = editCarPrice.text.toString()
            val messageDownPayment: String = editDownPayment.text.toString()
            val messageLoanPeriod: String = editLoanPeriod.text.toString()
            val messageInterestRate: String = editInterestRate.text.toString()

            if(messageCarPrice.trim().isNotEmpty() || messageDownPayment.trim().isNotEmpty() || messageLoanPeriod.trim().isNotEmpty() || messageInterestRate.trim().isNotEmpty())
            {
                if(messageCarPrice.trim().isNotEmpty())
                {
                    if(messageDownPayment.trim().isNotEmpty())
                    {
                        if(messageLoanPeriod.trim().isNotEmpty())
                        {
                            if(messageInterestRate.trim().isNotEmpty())
                            {
                                viewLoan.text = "Loan : " + decimal.format((carPrice().toDouble() - downPayment().toDouble()))
                                viewInterest.text = "Interest : " + decimal.format(((carPrice().toDouble() - downPayment().toDouble()) * interestRate().toDouble() * loanPeriod().toDouble()))
                                viewMonthlyRepayment.text = "Monthly Repayment : " + decimal.format(((((carPrice().toDouble() - downPayment().toDouble()) + ((carPrice().toDouble() - downPayment().toDouble()) * interestRate().toDouble() * loanPeriod().toDouble())) / loanPeriod().toDouble()) / 12))
                            }
                            else
                            {
                                Toast.makeText(applicationContext, "Please Enter InterestRate", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else
                        {
                            Toast.makeText(applicationContext, "Please Enter LoanPeriod", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else
                    {
                        Toast.makeText(applicationContext, "Please Enter DownPayment", Toast.LENGTH_SHORT).show()
                    }
                }
                else
                {
                    Toast.makeText(applicationContext, "Please Enter CarPrice", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext, "Please Enter CarPrice, DownPayment, LoanPeriod, InterestRate", Toast.LENGTH_SHORT).show()
            }
        })

        buttonForReset.setOnClickListener(View.OnClickListener
        {
                View -> editCarPrice.getText().clear();
            editDownPayment.getText().clear();
            editLoanPeriod.getText().clear();
            editInterestRate.getText().clear();
            viewLoan.text = "Loan : ";
            viewInterest.text = "Interest : ";
            viewMonthlyRepayment.text = "Monthly Repayment : "
        })
    }

    fun carPrice(): Int
    {
        val input_CarPrice = findViewById<EditText>(R.id.editTextCarPrice)
        return Integer.parseInt(input_CarPrice.text.toString())
    }

    fun downPayment(): Int
    {
        val input_DownPayment = findViewById<EditText>(R.id.editTextDownPayment)
        return Integer.parseInt(input_DownPayment.text.toString())
    }

    fun interestRate(): Int
    {
        val input_InterestRate = findViewById<EditText>(R.id.editTextInterestRate)
        return Integer.parseInt(input_InterestRate.text.toString())
    }

    fun loanPeriod(): Int
    {
        val input_LoadPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        return Integer.parseInt(input_LoadPeriod.text.toString())
    }
}