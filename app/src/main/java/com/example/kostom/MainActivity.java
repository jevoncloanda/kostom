package com.example.kostom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kostom.model.Room;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner roomSizeSpinner;
    CheckBox bathroomCheckbox;
    CheckBox acCheckbox;
    CheckBox tableCheckbox;
    CheckBox chairCheckbox;
    CheckBox wardrobeCheckbox;
    CheckBox tvCheckbox;
    Button checkAllButton;
    Button resetButton;
    Button reserveButton;

    double totalPrice = 0;
    double sizePrice = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roomSizeSpinner = findViewById(R.id.roomSizeSpinner);
        bathroomCheckbox = findViewById(R.id.bathroomCheckbox);
        acCheckbox = findViewById(R.id.acCheckbox);
        tableCheckbox = findViewById(R.id.tableCheckbox);
        chairCheckbox = findViewById(R.id.chairCheckbox);
        wardrobeCheckbox = findViewById(R.id.wardrobeCheckbox);
        tvCheckbox = findViewById(R.id.tvCheckbox);

        checkAllButton = findViewById(R.id.checkAllButton);
        resetButton = findViewById(R.id.resetButton);
        reserveButton = findViewById(R.id.reserveButton);

        ArrayList<String> roomSizeList = new ArrayList<>();
        roomSizeList.add("3x3");
        roomSizeList.add("4x4");
        roomSizeList.add("5x5");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roomSizeList);
        roomSizeSpinner.setAdapter(adapter);

        updateTotalPrice();

        checkAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAllCheckboxes();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uncheckAllCheckboxes();
            }
        });

        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedSize = roomSizeSpinner.getSelectedItem().toString();
                boolean hasBathroom = bathroomCheckbox.isChecked();
                boolean hasAC = acCheckbox.isChecked();
                boolean hasTable = tableCheckbox.isChecked();
                boolean hasChair = chairCheckbox.isChecked();
                boolean hasWardrobe = wardrobeCheckbox.isChecked();
                boolean hasTV = tvCheckbox.isChecked();

                Room selectedRoom = new Room(selectedSize, hasBathroom, hasAC, hasTable, hasChair, hasWardrobe, hasTV);

                Intent niatPindah = new Intent(MainActivity.this, PaymentActivity.class);
                niatPindah.putExtra("selectedRoom", selectedRoom);
                startActivity(niatPindah);
            }
        });
    }

    private void updateTotalPrice() {

        roomSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedItem = (String) parentView.getItemAtPosition(position);

                uncheckAllCheckboxes();

                totalPrice = 0;
                sizePrice = 0;
                if (selectedItem.equals("3x3")) {
                    sizePrice = 900000.0;
                } else if (selectedItem.equals("4x4")) {
                    sizePrice = 1300000.0;
                } else if (selectedItem.equals("5x5")) {
                    sizePrice = 1650000.0;
                }

                totalPrice += sizePrice;
                reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                sizePrice = 0;
                totalPrice += sizePrice;
                reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
            }
        });

        bathroomCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    totalPrice += 400000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    bathroomCheckbox.setText("Kamar Mandi (+ Rp 400.000)");
                } else {
                    totalPrice -= 400000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    bathroomCheckbox.setText("Kamar Mandi");
                }
            }
        });

        acCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    totalPrice += 300000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    acCheckbox.setText("AC (+ Rp 300.000)");
                } else {
                    totalPrice -= 300000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    acCheckbox.setText("AC");
                }
            }
        });

        tableCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    totalPrice += 40000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    tableCheckbox.setText("Meja (+ Rp 40.000)");
                } else {
                    totalPrice -= 40000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    tableCheckbox.setText("Meja");
                }
            }
        });

        chairCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    totalPrice += 40000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    chairCheckbox.setText("Kursi (+ Rp 40.000)");
                } else {
                    totalPrice -= 40000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    chairCheckbox.setText("Kursi");
                }
            }
        });

        wardrobeCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    totalPrice += 40000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    wardrobeCheckbox.setText("Lemari (+ Rp 40.000)");
                } else {
                    totalPrice -= 40000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    wardrobeCheckbox.setText("Lemari");
                }
            }
        });

        tvCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    totalPrice += 400000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    tvCheckbox.setText("TV (+ Rp 400.000)");
                } else {
                    totalPrice -= 400000.0;
                    reserveButton.setText("Lanjutkan Pembayaran Rp " + totalPrice);
                    tvCheckbox.setText("TV");
                }
            }
        });
    }

    private void uncheckAllCheckboxes() {
        bathroomCheckbox.setChecked(false);
        acCheckbox.setChecked(false);
        tableCheckbox.setChecked(false);
        chairCheckbox.setChecked(false);
        wardrobeCheckbox.setChecked(false);
        tvCheckbox.setChecked(false);
    }

    private void checkAllCheckboxes() {
        bathroomCheckbox.setChecked(true);
        acCheckbox.setChecked(true);
        tableCheckbox.setChecked(true);
        chairCheckbox.setChecked(true);
        wardrobeCheckbox.setChecked(true);
        tvCheckbox.setChecked(true);
    }
}
