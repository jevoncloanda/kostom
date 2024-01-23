package com.example.kostom;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kostom.model.Room;

public class PaymentActivity extends AppCompatActivity {

    private Room selectedRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView orderDetailsTextView = findViewById(R.id.orderDetailsTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);
        RadioGroup paymentMethodRadioGroup = findViewById(R.id.paymentMethodRadioGroup);
        Button payButton = findViewById(R.id.payButton);

        selectedRoom = getIntent().getParcelableExtra("selectedRoom");

        String orderDetails = "Detail Pesanan:\n" +
                "Ukuran Kamar: " + selectedRoom.getSize() + "\n" +
                "Kamar Mandi: " + selectedRoom.getHasBathroom() + "\n" +
                "AC: " + selectedRoom.getHasAC() + "\n" +
                "Meja: " + selectedRoom.getHasTable() + "\n" +
                "Kursi: " + selectedRoom.getHasChair() + "\n" +
                "Lemari: " + selectedRoom.getHasWardrobe() + "\n" +
                "TV: " + selectedRoom.getHasTV();

        orderDetailsTextView.setText(orderDetails);

        double totalPrice = calculateTotalPrice(selectedRoom);

        String priceDetails = "Harga: Rp " + totalPrice;
        priceTextView.setText(priceDetails);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedPaymentMethodId = paymentMethodRadioGroup.getCheckedRadioButtonId();
                RadioButton selectedPaymentMethod = findViewById(selectedPaymentMethodId);

                String paymentDetails = "Metode Pembayaran: " + selectedPaymentMethod.getText().toString();
                Toast.makeText(PaymentActivity.this, paymentDetails, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double calculateTotalPrice(Room room) {
        double sizePrice = 0;

        if (room.getSize().equals("3x3")) {
            sizePrice = 900000.0;
        } else if (room.getSize().equals("4x4")) {
            sizePrice = 1300000.0;
        } else if (room.getSize().equals("5x5")) {
            sizePrice = 1650000.0;
        }
        double bathroomPrice = room.getHasBathroom() ? 400000.0 : 0.0;
        double acPrice = room.getHasAC() ? 300000.0 : 0.0;
        double tablePrice = room.getHasTable() ? 40000.0 : 0.0;
        double chairPrice = room.getHasChair() ? 40000.0 : 0.0;
        double wardrobePrice = room.getHasWardrobe() ? 40000.0 : 0.0;
        double tvPrice = room.getHasTV() ? 400000.0 : 0.0;

        return sizePrice + bathroomPrice + acPrice + tablePrice + chairPrice + wardrobePrice + tvPrice;
    }
}
