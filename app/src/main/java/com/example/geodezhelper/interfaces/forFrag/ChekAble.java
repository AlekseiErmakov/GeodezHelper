package com.example.geodezhelper.interfaces.forFrag;

import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public interface ChekAble {
     Map<EditText,TextView> getViews();
     Double chekDouble (EditText text, Map<EditText, TextView> views);
     Integer chekText (EditText text, Map<EditText, TextView> views);
     String chekName(EditText text, Map<EditText, TextView> views);
}
