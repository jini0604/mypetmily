package com.example.cteam.board;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cteam.ATask.Board.Boardinsert;
import com.example.cteam.Common.CommonMethod;
import com.example.cteam.Login;
import com.example.cteam.PetSelect;
import com.example.cteam.R;

import java.io.File;
import java.util.concurrent.ExecutionException;

import static com.example.cteam.Common.CommonMethod.isNetworkConnected;
import static com.example.cteam.PetAdd.petAddDto;

public class BoardWrite extends AppCompatActivity {

    private static final String TAG = "BoardWrite";

    Spinner board_write_subject, board_write_region1, board_write_region2;
    EditText board_write_title, board_write_content;
    Button board_write_filebutton, board_write_cancel, board_write_submit;
    ImageView board_write_image;


    ArrayAdapter<CharSequence> adspin1, adspin2;

    File file = null;
    long fileSize = 0;
    public String imageRealPathA, imageDbPathA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_write);

        board_write_subject = findViewById(R.id.board_write_subject);
        board_write_region1 = findViewById(R.id.board_write_region1);
        board_write_region2 = findViewById(R.id.board_write_region2);
        board_write_title = findViewById(R.id.board_write_title);
        board_write_content = findViewById(R.id.board_write_content);
        board_write_filebutton = findViewById(R.id.board_write_filebutton);
        board_write_cancel = findViewById(R.id.board_write_cancel);
        board_write_submit = findViewById(R.id.board_write_submit);
        board_write_image = findViewById(R.id.board_write_image);


        board_write_content.setMovementMethod(new ScrollingMovementMethod());


        final Spinner spin1 = (Spinner)findViewById(R.id.board_write_region1);
        final Spinner spin2 = (Spinner)findViewById(R.id.board_write_region2);
        adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_region, android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adspin1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adspin1.getItem(i).equals("???????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_seoul, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("???????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_busan, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("???????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_daegu, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("???????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_incheon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("???????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_gwangju, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("???????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_daejeon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("???????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_ulsan, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("?????????????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_sejong, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("?????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_gyeonggi, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("?????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_gangwon, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_chung_buk, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_chung_nam, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_jeon_buk, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_jeon_nam, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_gyeong_buk, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_gyeong_nam, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }else if(adspin1.getItem(i).equals("?????????????????????")) {
                    adspin2 = ArrayAdapter.createFromResource(BoardWrite.this, R.array.spinner_region_jeju, android.R.layout.simple_spinner_dropdown_item);
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin2.setAdapter(adspin2);
                    spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //?????? ??????
        board_write_filebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                board_write_image.setVisibility(View.VISIBLE);

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 15);
            }
        });

        board_write_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showIntent = new Intent(getApplicationContext(), PetSelect.class);
                showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_SINGLE_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TOP);
                showIntent.putExtra("fragment", "BoardWrite");
                startActivity(showIntent);

                finish();

            }
        });

    }

    //???????????? ?????????
    public void btnBoardinsert(View view){
        if(isNetworkConnected(this) == true){
            Log.d(TAG, "btnBoardinsert: ??????????????????");
            if(fileSize <= 30000000){  // ??????????????? 30?????? ?????? ????????? ????????? ?????? ??????
                String title = board_write_title.getText().toString();
                String content = board_write_content.getText().toString();
                String subject = board_write_subject.getSelectedItem().toString();
                String city = board_write_region1.getSelectedItem().toString();
                String region = board_write_region2.getSelectedItem().toString();

                Log.d(TAG, "btnBoardinsert: " + title + content + subject + city + region);
//                Boardinsert boardinsert = new Boardinsert(board_write_title, board_write_content, board_write_subject, board_write_region1, board_write_region2, imageDbPathA,imageRealPathA,);
//                boardinsert.execute();

/*
                Intent showIntent = new Intent(getApplicationContext(), WalkBoard.class);
                showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |   // ??? ???????????? ???????????? ???????????? ??????????????? ???????????? ?????? ????????? ???????????? ???????????? ??? ??????????????? ??????????????? ???????????? ?????????. ???, ????????? ???????????? ?????????????????? ??????????????? ??????????????? ????????? affinity(??????, ??????)??? ????????? ?????? ???????????? ????????? ???????????? ??? ??????????????? ?????????????????????.
                        Intent.FLAG_ACTIVITY_SINGLE_TOP | // ??????????????? ????????? ?????? ????????? ??????????????? ?????? ???????????? ???????????? ???????????? ???????????? ????????? ??????????????? ???????????? ????????????. ?????? ?????? ABC??? ???????????? ????????? ???????????? ???????????? C??? ?????????????????? ????????? ABC??? ???????????? ?????????.
                        Intent.FLAG_ACTIVITY_CLEAR_TOP); // ????????? ????????????????????? ??????????????? ??????????????? ??????????????? ?????? ???????????? ?????? ????????? ????????? ??????????????? ???????????? ??? ????????? ???????????? ?????? ??????????????? ?????????????????? ???????????????. ????????? ????????????????????? ????????? ?????????????????? ?????????????????? ????????? ????????????????????? ?????? ??????????????? ???????????????.
                startActivity(showIntent);
*/
                Boardinsert boardinsert = new Boardinsert(subject, title, content, city, region,
                        imageDbPathA, imageRealPathA, Login.loginDTO.getMember_id(), petAddDto.petname, petAddDto.getPetimage_path());
                try {
                    boardinsert.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent showIntent = new Intent(getApplicationContext(), PetSelect.class);
                showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_SINGLE_TOP |
                        Intent.FLAG_ACTIVITY_CLEAR_TOP);
                showIntent.putExtra("fragment", "Boardwrite");
                startActivity(showIntent);

                finish();



            }else{
                // ????????? ??????
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("??????");
                builder.setMessage("?????? ????????? 30MB???????????? ????????? ???????????? ???????????? ????????????.\n30MB?????? ????????? ????????? ????????????!!!");
                builder.setPositiveButton("???", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }

        }else {
            Toast.makeText(this, "???????????? ???????????? ?????? ????????????.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    //????????????
//    public void btnBoardcancel(View view){
//        onBackPressed();
//        Intent showIntent = new Intent(getApplicationContext(), PetSelect.class);
//        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
//            Intent.FLAG_ACTIVITY_SINGLE_TOP |
//            Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        showIntent.putExtra("Fragment", "BoardWrite");
//        startActivity(showIntent);
//
//        finish();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 15 && resultCode == RESULT_OK) {
            try {
                String path = "";
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    // Get the path from the Uri
                    path = getPathFromURI(selectedImageUri);
                }
                // ????????? ????????? ??? ????????????
                Bitmap newBitmap = CommonMethod.imageRotateAndResize(path);
                if(newBitmap != null){
                    board_write_image.setImageBitmap(newBitmap);
                }else{
                    Toast.makeText(this, "???????????? null ?????????...", Toast.LENGTH_SHORT).show();
                }

                imageRealPathA = path;
                Log.d("BoardWrite", "imageFilePathA Path : " + imageRealPathA);
                String uploadFileName = imageRealPathA.split("/")[imageRealPathA.split("/").length - 1];
                imageDbPathA = CommonMethod.ipConfig + "/app/resources/" + uploadFileName;

            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    // Get the real path from the URI
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }



}