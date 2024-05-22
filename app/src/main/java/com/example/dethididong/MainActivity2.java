package com.example.dethididong;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextName, editTextMath, editTextLiterature, editTextLanguage;
    private Button buttonAddStudent, buttonFindMax, buttonFindMin, buttonSort;
    private ListView listViewStudents;
    private List<Student> studentList;
    private ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Ánh xạ các thành phần giao diện
        editTextName = findViewById(R.id.editTextName);
        editTextMath = findViewById(R.id.editTextMath);
        editTextLiterature = findViewById(R.id.editTextLiterature);
        editTextLanguage = findViewById(R.id.editTextLanguage);
        buttonAddStudent = findViewById(R.id.buttonAddStudent);
        buttonFindMax = findViewById(R.id.buttonFindMax);
        buttonFindMin = findViewById(R.id.buttonFindMin);
        buttonSort = findViewById(R.id.buttonSort);
        listViewStudents = findViewById(R.id.listViewStudents);

        studentList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listViewStudents.setAdapter(adapter);

        // Sự kiện khi nhấn nút "Thêm học sinh"
        buttonAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int math = Integer.parseInt(editTextMath.getText().toString());
                int literature = Integer.parseInt(editTextLiterature.getText().toString());
                int language = Integer.parseInt(editTextLanguage.getText().toString());

                int totalScore = math + literature + language;
                Student student = new Student(name, math, literature, language, totalScore);
                studentList.add(student);
                adapter.notifyDataSetChanged();

                // Reset giá trị nhập liệu
                editTextName.setText("");
                editTextMath.setText("");
                editTextLiterature.setText("");
                editTextLanguage.setText("");
            }
        });

        // Sự kiện khi nhấn nút "Học sinh có tổng điểm cao nhất"
        buttonFindMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentList.isEmpty()) {
                    showToast("Chưa có học sinh trong danh sách.");
                    return;
                }

                Student maxStudent = Collections.max(studentList, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Integer.compare(s1.getTotalScore(), s2.getTotalScore());
                    }
                });

                showToast("Học sinh có tổng điểm cao nhất: " + maxStudent.getName());
            }
        });

        // Sự kiện khi nhấn nút "Học sinh có tổng điểm nhỏ nhất"
        buttonFindMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentList.isEmpty()) {
                    showToast("Chưa có học sinh trong danh sách.");
                    return;
                }

                Student minStudent = Collections.min(studentList, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Integer.compare(s1.getTotalScore(), s2.getTotalScore());
                    }
                });

                showToast("Học sinh có tổng điểm nhỏ nhất: " + minStudent.getName());
            }
        });

        // Sự kiện khi nhấn nút "Sắp xếp danh sách"
        buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentList.isEmpty()) {
                    showToast("Chưa có học sinh trong danh sách.");
                    return;
                }

                Collections.sort(studentList, new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Integer.compare(s2.getTotalScore(), s1.getTotalScore());
                    }
                });

                adapter.notifyDataSetChanged();
            }
        });

        // Sự kiện khi nhấn vào một học sinh trong danh sách
        listViewStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student selectedStudent = studentList.get(position);
                showToast("Học sinh được chọn: " + selectedStudent.getName());
            }
        });
    }

    // Phương thức hiển thị thông báo Toast
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

