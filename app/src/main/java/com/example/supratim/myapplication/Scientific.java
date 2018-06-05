package com.example.supratim.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link standard.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link standard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Scientific extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Scientific newInstance(String param1, String param2) {
        Scientific fragment = new Scientific();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Scientific() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30;
     // final boolean power;
        float ValueOne,ValueTwo;
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_standard, container, false);
        b1=(Button)view.findViewById(R.id.bt1);
        b2=(Button)view.findViewById(R.id.bt2);
        b3=(Button)view.findViewById(R.id.bt3);
        b4=(Button)view.findViewById(R.id.bt4);
        b5=(Button)view.findViewById(R.id.bt5);
        b6=(Button)view.findViewById(R.id.bt6);
        b7=(Button)view.findViewById(R.id.bt7);
        b8=(Button)view.findViewById(R.id.bt8);
        b9=(Button)view.findViewById(R.id.bt9);
        b10=(Button)view.findViewById(R.id.bt10);
        b11=(Button)view.findViewById(R.id.bt11);
        b12=(Button)view.findViewById(R.id.bt12);
        b13=(Button)view.findViewById(R.id.bt13);
        b14=(Button)view.findViewById(R.id.bt14);
        b15=(Button)view.findViewById(R.id.bt15);
        b16=(Button)view.findViewById(R.id.bt16);
        b17=(Button)view.findViewById(R.id.bt17);
        b18=(Button)view.findViewById(R.id.bt18);
        b19=(Button)view.findViewById(R.id.bt19);
        b20=(Button)view.findViewById(R.id.bt20);
        b21=(Button)view.findViewById(R.id.bt21);
        b22=(Button)view.findViewById(R.id.bt22);
        b23=(Button)view.findViewById(R.id.bt23);
        b24=(Button)view.findViewById(R.id.bt24);
        b25=(Button)view.findViewById(R.id.bt25);
        b26=(Button)view.findViewById(R.id.bt26);
        b27=(Button)view.findViewById(R.id.bt27);
        b28=(Button)view.findViewById(R.id.bt28);
        b29=(Button)view.findViewById(R.id.bt29);
        b30=(Button)view.findViewById(R.id.bt30);



        b29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MainActivity) getActivity()).Addition == true||((MainActivity) getActivity()).Division == true||((MainActivity) getActivity()).Subtract == true||((MainActivity) getActivity()).Multiplication == true) {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                    float result1;String fourth;
                    if (second.charAt(0)=='-') {
                        result1 = (-1)*infixtopostfix(second.substring(1));
                        fourth=String.valueOf(String.format("%.4f",result1));
                    }
                    else {
                        result1 = infixtopostfix(second);
                        fourth=String.valueOf(String.format("%.4f", result1));
                    }
                    ((MainActivity) getActivity()).et1.setText(second + "="+fourth+"");
                }
                //  ValueTwo = Float.parseFloat(et1.getText() + "");

//                if (((MainActivity) getActivity()).Addition == true) {
//                    String second = ((MainActivity) getActivity()).et1.getText().toString();
//                    ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0, second.lastIndexOf('+')) + "");
//                    ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('+') + 1) + "");
//                    ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne + ((MainActivity) getActivity()).ValueTwo + "");
//                    ((MainActivity) getActivity()).Addition = false;
//                }
//                if (((MainActivity) getActivity()).fact == true) {
//                    String second = ((MainActivity) getActivity()).et1.getText().toString();
//                    ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0, second.lastIndexOf('!')) + "");
//                   // ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('!') + 1) + "");
//                    long f=1;
//                    for (int i =1;i<=((MainActivity) getActivity()).ValueOne;i++)
//                        f=f*i;
//                        ((MainActivity) getActivity()).et1.setText(f+"");
//                    ((MainActivity) getActivity()).fact = false;
//                }
//
//
//                if (((MainActivity) getActivity()).Subtract == true) {
//                    String second = ((MainActivity) getActivity()).et1.getText().toString();
//                    ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0, second.lastIndexOf('-')) + "");
//                    ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('-') + 1) + "");
//                    ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne - ((MainActivity) getActivity()).ValueTwo + "");
//                    ((MainActivity) getActivity()).Subtract = false;
//                }
//
//                if (((MainActivity) getActivity()).Multiplication == true) {
//                    String second = ((MainActivity) getActivity()).et1.getText().toString();
//                    ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0, second.lastIndexOf('*')) + "");
//                    ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('*') + 1) + "");
//                    String str=String.valueOf(String.format("%.4f",((MainActivity)getActivity()).ValueOne * ((MainActivity)getActivity()).ValueTwo));
//                    //Log.e("value:0",str);
////                    if (str.contains("E")) {
////                        String str1 = str.substring(0, str.lastIndexOf('E'));
////                        String str2 = str.substring(str.lastIndexOf('E') + 1);
////                        String st =  "10^" + str2+ "*" + str1;
////                        ((MainActivity) getActivity()).et1.setText(st + "");
////                        // Log.e("value1",st);
////
////                    }
////                    else
//                        ((MainActivity)getActivity()).et1.setText(str+"");
//                    ((MainActivity)getActivity()).Multiplication=false;
//                }
//
//                if (((MainActivity) getActivity()).Division == true) {
//                    String second = ((MainActivity) getActivity()).et1.getText().toString();
//                    ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0, second.lastIndexOf('/')) + "");
//                    ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('/') + 1) + "");
//                    ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne / ((MainActivity) getActivity()).ValueTwo + "");
//                    ((MainActivity) getActivity()).Division = false;
//                }
//                if( ((MainActivity)getActivity()).power == true) {
//                    String second = ((MainActivity) getActivity()).et1.getText().toString();
//                    ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0, second.lastIndexOf('^')) + "");
//                    ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('^') + 1) + "");
//                    ((MainActivity) getActivity()).et1.setText(Math.pow(((MainActivity) getActivity()).ValueOne , ((MainActivity) getActivity()).ValueTwo) + "");
//                    ((MainActivity)getActivity()).power = false;
//                }
                if( ((MainActivity)getActivity()).root == true) {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                    if (second.charAt(0) == '√') {
                        ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(1) + "");
                         ((MainActivity) getActivity()).et1.setText(Math.sqrt(((MainActivity) getActivity()).ValueTwo) + "");
                    }
                        else
                    {
                        ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0, second.lastIndexOf('√')) + "");
                        ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('√') + 1) + "");
                        ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne * Math.sqrt(((MainActivity) getActivity()).ValueTwo) + "");

                    }
                    ((MainActivity) getActivity()).root = false;
                }

                if( ((MainActivity)getActivity()).pi == true) {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                    if (second.charAt(0) == 'π'&&second.length()!=1) {
                        ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('π')+1) + "");
                        ((MainActivity) getActivity()).et1.setText(Math.PI *(((MainActivity) getActivity()).ValueTwo) + "");
                    }
                    else if (second.charAt(second.length()-1)=='π'&& second.length()!=1)
                    {
                        ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0,second.lastIndexOf('π')) + "");
                        ((MainActivity) getActivity()).et1.setText((((MainActivity) getActivity()).ValueOne)*Math.PI + "");
                    }
                    else if (second.charAt(0) == 'π' && second.charAt(second.length()-1)=='π' && second.length()==1)

                    {
                        ((MainActivity) getActivity()).et1.setText(Math.PI + "");
                    }

                    else
                    {
                        ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0, second.lastIndexOf('π')) + "");
                        ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('π') + 1) + "");

                        ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne * Math.PI * ((MainActivity) getActivity()).ValueTwo + "");

                    }
                    ((MainActivity) getActivity()).pi = false;
                }
                if( ((MainActivity)getActivity()).log == true) {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                    String firststr=""+second.substring(0,second.lastIndexOf('l'));
                    String secondstr=second.substring(second.lastIndexOf('(')+1,second.lastIndexOf(')'));
                    String thirdstr=second.substring(second.lastIndexOf(')')+1)+"";
                    //Log.e("message1",firststr);
                    //Log.e("message2",secondstr);
                    //  Log.d("message3",thirdstr);

                    if ((second.charAt(0)=='l') &&(thirdstr=="") && (firststr==""))
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(Math.log(((MainActivity) getActivity()).ValueTwo)/Math.log(10) +"");

                    }
                    else if (second.charAt(0)=='l' && thirdstr!="")
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).ValueThree=Float.parseFloat(thirdstr);
                        ((MainActivity)getActivity()).et1.setText(Math.log(((MainActivity) getActivity()).ValueTwo)/Math.log(10) *((MainActivity)getActivity()).ValueThree+"");
                    }
                    else if(firststr!="" && thirdstr=="")
                    {
                        ((MainActivity)getActivity()).ValueOne=Float.parseFloat(firststr+"");
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).ValueOne*Math.log(((MainActivity) getActivity()).ValueTwo)/Math.log(10) +"");
                    }
                    else if ((firststr != "") && (thirdstr != "")) {
                        ((MainActivity) getActivity()).ValueOne = Float.parseFloat(firststr + "");
                        ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(secondstr + "");
                        ((MainActivity) getActivity()).ValueThree = Float.parseFloat(thirdstr);
                        ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne * Math.log(((MainActivity) getActivity()).ValueTwo)/Math.log(10) * ((MainActivity) getActivity()).ValueThree + "");

                    }
                    ((MainActivity) getActivity()).log = false;
                }
                if( ((MainActivity)getActivity()).loge == true) {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                    String firststr=""+second.substring(0,second.lastIndexOf('l'));
                    String secondstr=second.substring(second.lastIndexOf('(')+1,second.lastIndexOf(')'));
                    String thirdstr=second.substring(second.lastIndexOf(')')+1)+"";
                    //Log.e("message1",firststr);
                    //Log.e("message2",secondstr);
                    //  Log.d("message3",thirdstr);

                    if ((second.charAt(0)=='l') &&(thirdstr=="") && (firststr==""))
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(Math.log(((MainActivity) getActivity()).ValueTwo) +"");

                    }
                    else if (second.charAt(0)=='l' && thirdstr!="")
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).ValueThree=Float.parseFloat(thirdstr);
                        ((MainActivity)getActivity()).et1.setText(Math.log(((MainActivity) getActivity()).ValueTwo) *((MainActivity)getActivity()).ValueThree+"");
                    }
                    else if(firststr!="" && thirdstr=="")
                    {
                        ((MainActivity)getActivity()).ValueOne=Float.parseFloat(firststr+"");
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).ValueOne*Math.log(((MainActivity) getActivity()).ValueTwo) +"");
                    }
                    else if ((firststr != "") && (thirdstr != "")) {
                        ((MainActivity) getActivity()).ValueOne = Float.parseFloat(firststr + "");
                        ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(secondstr + "");
                        ((MainActivity) getActivity()).ValueThree = Float.parseFloat(thirdstr);
                        ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne * Math.log(((MainActivity) getActivity()).ValueTwo) * ((MainActivity) getActivity()).ValueThree + "");

                    }
                    ((MainActivity) getActivity()).loge = false;
                }
                if( ((MainActivity)getActivity()).sine == true) {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                    String firststr=""+second.substring(0,second.lastIndexOf('s'));
                    String secondstr=second.substring(second.lastIndexOf('(')+1,second.lastIndexOf(')'));
                    String thirdstr=second.substring(second.lastIndexOf(')')+1)+"";
                    //Log.e("message1",firststr);
                    //Log.e("message2",secondstr);
                  //  Log.d("message3",thirdstr);

                    if ((second.charAt(0)=='s') &&(thirdstr=="") && (firststr==""))
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(Math.sin(((MainActivity)getActivity()).ValueTwo)+"");

                    }
                    else if (second.charAt(0)=='s' && thirdstr!="")
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).ValueThree=Float.parseFloat(thirdstr);
                        ((MainActivity)getActivity()).et1.setText(Math.sin(((MainActivity)getActivity()).ValueTwo)*((MainActivity)getActivity()).ValueThree+"");
                    }
                    else if(firststr!="" && thirdstr=="")
                    {
                        ((MainActivity)getActivity()).ValueOne=Float.parseFloat(firststr+"");
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).ValueOne*Math.sin(((MainActivity)getActivity()).ValueTwo)+"");
                    }
                    else if ((firststr != "") && (thirdstr != "")) {
                        ((MainActivity) getActivity()).ValueOne = Float.parseFloat(firststr + "");
                        ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(secondstr + "");
                        ((MainActivity) getActivity()).ValueThree = Float.parseFloat(thirdstr);
                        ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne * Math.sin(((MainActivity) getActivity()).ValueTwo) * ((MainActivity) getActivity()).ValueThree + "");

                    }
                    ((MainActivity) getActivity()).sine = false;
                }
                if( ((MainActivity)getActivity()).cosine == true) {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                    String firststr=""+second.substring(0,second.lastIndexOf('c'));
                    String secondstr=second.substring(second.lastIndexOf('(')+1,second.lastIndexOf(')'));
                    String thirdstr=second.substring(second.lastIndexOf(')')+1)+"";
                    //Log.e("message1",firststr);
                    //Log.e("message2",secondstr);
                    //  Log.d("message3",thirdstr);

                    if ((second.charAt(0)=='c') &&(thirdstr=="") && (firststr==""))
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(Math.cos(((MainActivity) getActivity()).ValueTwo)+"");

                    }
                    else if (second.charAt(0)=='c' && thirdstr!="")
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).ValueThree=Float.parseFloat(thirdstr);
                        ((MainActivity)getActivity()).et1.setText(Math.cos(((MainActivity) getActivity()).ValueTwo)*((MainActivity)getActivity()).ValueThree+"");
                    }
                    else if(firststr!="" && thirdstr=="")
                    {
                        ((MainActivity)getActivity()).ValueOne=Float.parseFloat(firststr+"");
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).ValueOne*Math.cos(((MainActivity) getActivity()).ValueTwo)+"");
                    }
                    else if ((firststr != "") && (thirdstr != "")) {
                        ((MainActivity) getActivity()).ValueOne = Float.parseFloat(firststr + "");
                        ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(secondstr + "");
                        ((MainActivity) getActivity()).ValueThree = Float.parseFloat(thirdstr);
                        ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne * Math.cos(((MainActivity) getActivity()).ValueTwo) * ((MainActivity) getActivity()).ValueThree + "");
                    }
                    ((MainActivity) getActivity()).cosine = false;
                }
                if( ((MainActivity)getActivity()).tangent == true) {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                    String firststr=""+second.substring(0,second.lastIndexOf('t'));
                    String secondstr=second.substring(second.lastIndexOf('(')+1,second.lastIndexOf(')'));
                    String thirdstr=second.substring(second.lastIndexOf(')')+1)+"";
                    //Log.e("message1",firststr);
                    //Log.e("message2",secondstr);
                    //  Log.d("message3",thirdstr);

                    if ((second.charAt(0)=='t') &&(thirdstr=="") && (firststr==""))
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(Math.tan(((MainActivity)getActivity()).ValueTwo)+"");

                    }
                    else if (second.charAt(0)=='t' && thirdstr!="")
                    {
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).ValueThree=Float.parseFloat(thirdstr);
                        ((MainActivity)getActivity()).et1.setText(Math.tan(((MainActivity)getActivity()).ValueTwo)*((MainActivity)getActivity()).ValueThree+"");
                    }
                    else if(firststr!="" && thirdstr=="")
                    {
                        ((MainActivity)getActivity()).ValueOne=Float.parseFloat(firststr+"");
                        ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(secondstr+"");
                        ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).ValueOne*Math.tan(((MainActivity)getActivity()).ValueTwo)+"");
                    }
                    else if ((firststr != "") && (thirdstr != "")) {
                        ((MainActivity) getActivity()).ValueOne = Float.parseFloat(firststr + "");
                        ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(secondstr + "");
                        ((MainActivity) getActivity()).ValueThree = Float.parseFloat(thirdstr);
                        ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne * Math.tan(((MainActivity) getActivity()).ValueTwo) * ((MainActivity) getActivity()).ValueThree + "");
                    }
                    ((MainActivity) getActivity()).tangent = false;
                }
                if (((MainActivity)getActivity()).exponent == true)
                {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                    ((MainActivity) getActivity()).ValueOne = Float.parseFloat(second.substring(0, second.lastIndexOf('e')) + "");
                    ((MainActivity) getActivity()).ValueTwo = Float.parseFloat(second.substring(second.lastIndexOf('e') + 1) + "");
                    if ((second.substring(0, second.lastIndexOf('e'))!=null) &&(second.substring(second.lastIndexOf('e') + 1)!=null) )
                    {
                        ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).ValueOne*(Math.pow(10,((MainActivity) getActivity()).ValueTwo))+"");
                    }
                    else if((second.length()==1)&&((second.substring(0, second.lastIndexOf('e'))==null) ||(second.substring(second.lastIndexOf('e') + 1)==null)))
                        ((MainActivity) getActivity()).et1.setText("ERROR");
                    ((MainActivity) getActivity()).exponent = false;
                }
            }

        });

        if ((((MainActivity)getActivity()).fact != true)||(((MainActivity)getActivity()).loge != true)||(((MainActivity)getActivity()).log != true)||(((MainActivity)getActivity()).tangent != true)||(((MainActivity)getActivity()).cosine != true)||(((MainActivity)getActivity()).sine != true)||(((MainActivity)getActivity()).pi!=true)||(((MainActivity)getActivity()).exponent!=true)||(((MainActivity)getActivity()).root!=true)||(((MainActivity)getActivity()).Addition!=true)||(((MainActivity)getActivity()).Subtract!=true)||(((MainActivity)getActivity()).Multiplication!=true)||(((MainActivity)getActivity()).Division!=true)||(((MainActivity)getActivity()).power!=true))
        {
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (((MainActivity)getActivity()).et1 == null) {
                        ((MainActivity)getActivity()).et1.setText("");
                    } else {
                        //  ValueOne = Float.parseFloat(et1.getText() + "");

                        ((MainActivity)getActivity()).power = true;
                        //  String second=((MainActivity)getActivity()).et1.getText().toString();
                        //  char prevop=second.charAt(second.indexOf('+'));
                        //  char prop=second.charAt(second.lastIndexOf('+'));
                        //  if (prevop!=prop)
                        ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText() + "^");
                    }
                }
            });


            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (((MainActivity)getActivity()).et1 == null) {
                        ((MainActivity)getActivity()).et1.setText("");
                    } else {
                        //  ValueOne = Float.parseFloat(et1.getText() + "");

                            ((MainActivity) getActivity()).root = true;
                        //  String second=((MainActivity)getActivity()).et1.getText().toString();
                        //  char prevop=second.charAt(second.indexOf('+'));
                        //  char prop=second.charAt(second.lastIndexOf('+'));
                        //  if (prevop!=prop)
                        ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText() + "√");
                    }
                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (((MainActivity)getActivity()).et1 == null) {
                        ((MainActivity)getActivity()).et1.setText("");
                    } else {
                        //  ValueOne = Float.parseFloat(et1.getText() + "");

                        ((MainActivity)getActivity()).pi = true;
                        //  String second=((MainActivity)getActivity()).et1.getText().toString();
                        //  char prevop=second.charAt(second.indexOf('+'));
                        //  char prop=second.charAt(second.lastIndexOf('+'));
                        //  if (prevop!=prop)
                        ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText() + "π");
                    }
                }
            });
            b30.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (((MainActivity)getActivity()).et1 == null) {
                        ((MainActivity)getActivity()).et1.setText("");
                    } else {
                        //  ValueOne = Float.parseFloat(et1.getText() + "");

                        ((MainActivity) getActivity()).Addition = true;
                        String second=((MainActivity)getActivity()).et1.getText().toString();
                        //  char prevop=second.charAt(second.indexOf('*'));
                        // char prop=second.charAt(second.lastIndexOf('*'));
                        // if (prevop!=prop)
                        if (second.contains("=")) {
                            //String third = second.substring(0, second.lastIndexOf('='));
                            String third=second.substring(second.lastIndexOf('=')+1);
                            ((MainActivity) getActivity()).et1.setText(third + "+");
                        }
                        else
                            ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "+");
                    }
                }
            });

            b25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (((MainActivity)getActivity()).et1 == null) {
                        ((MainActivity)getActivity()).et1.setText("");
                    } else {
                        //ValueOne = Float.parseFloat(et1.getText() + "");
                        ((MainActivity)getActivity()).Subtract = true;
                        //((MainActivity) getActivity()).Addition = true;
                        String second=((MainActivity)getActivity()).et1.getText().toString();
                        //  char prevop=second.charAt(second.indexOf('*'));
                        // char prop=second.charAt(second.lastIndexOf('*'));
                        // if (prevop!=prop)
                        if (second.contains("=")) {
                            //String third = second.substring(0, second.lastIndexOf('='));
                            String third=second.substring(second.lastIndexOf('=')+1);
                            ((MainActivity) getActivity()).et1.setText(third + "-");
                        }
                        else
                            ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "-");
                    }
                }
            });
            b20.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (((MainActivity)getActivity()).et1 == null) {
                        ((MainActivity)getActivity()).et1.setText("");
                    } else {
                        //ValueOne = Float.parseFloat(et1.getText() + "");
                        ((MainActivity) getActivity()).Multiplication = true;
                        String second=((MainActivity)getActivity()).et1.getText().toString();
                        //  char prevop=second.charAt(second.indexOf('*'));
                        // char prop=second.charAt(second.lastIndexOf('*'));
                        // if (prevop!=prop)
                        if (second.contains("=")) {
                            //String third = second.substring(0, second.lastIndexOf('='));
                            String third=second.substring(second.lastIndexOf('=')+1);
                            ((MainActivity) getActivity()).et1.setText(third + "*");
                        }
                        else
                            ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "*");
                    }
                }
            });
            //   char temp=' ',prop;
            b15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  char temp=' ',prop;
                    if (((MainActivity)getActivity()).et1 == null) {
                        ((MainActivity)getActivity()).et1.setText("");
                    } else {
                        //ValueOne = Float.parseFloat(et1.getText() + "");
                        ((MainActivity) getActivity()).Division = true;
                        String second=((MainActivity)getActivity()).et1.getText().toString();
                        //  char prevop=second.charAt(second.indexOf('*'));
                        // char prop=second.charAt(second.lastIndexOf('*'));
                        // if (prevop!=prop)
                        if (second.contains("=")) {
                            //String third = second.substring(0, second.lastIndexOf('='));
                            String third=second.substring(second.lastIndexOf('=')+1);
                            ((MainActivity) getActivity()).et1.setText(third + "/");
                        }
                        else
                            ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "/");
                        // }
                    }
                }
            });
        }
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"(");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+")"+"");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (((MainActivity) getActivity()).et1 == null) {
                    ((MainActivity) getActivity()).et1.setText("");
                }
                else {
                    ((MainActivity)getActivity()).sine = true;
                    ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "sin(");
                }
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (((MainActivity) getActivity()).et1 == null) {
                    ((MainActivity) getActivity()).et1.setText("");
                } else {
                    ((MainActivity) getActivity()).cosine = true;
                    ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "cos(");
                }
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (((MainActivity) getActivity()).et1 == null) {
                    ((MainActivity) getActivity()).et1.setText("");
                } else {
                    ((MainActivity) getActivity()).tangent = true;
                    ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "tan(");
                }
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                if (((MainActivity) getActivity()).et1 == null) {
                    ((MainActivity) getActivity()).et1.setText("");
                } else {
                    ((MainActivity) getActivity()).loge = true;
                    // Perform action on click
                    ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "ln(");
                }
            }
        });
        b26.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((MainActivity) getActivity()).et1 == null) {
                    ((MainActivity) getActivity()).et1.setText("");
                } else {
                    ((MainActivity) getActivity()).log = true;
                    // Perform action on click
                    ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "log(");
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivity)getActivity()).fact=true;
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"!");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((MainActivity)getActivity()).et1 == null) {
                    ((MainActivity)getActivity()).et1.setText("");
                } else {
                    //ValueOne = Float.parseFloat(et1.getText() + "");
                    ((MainActivity)getActivity()).exponent = true;
                    // String second=((MainActivity)getActivity()).et1.getText().toString();
                    //char prevop=second.charAt(second.indexOf('/'));
                    //  prop=second.charAt(second.lastIndexOf('/'));

                    //if (temp!=prop) {
                    //   temp = prop;
                    ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "e");
                    // }
                }
                // Perform action on click

            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"7");
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText() + "8");
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"9");
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"4");
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"5");
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"6");
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"1");
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"2");
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"3");
            }
        });
        b27.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+"0");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText("");
            }
        });
        b28.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).et1.getText()+".");
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String oldValue=((MainActivity)getActivity()).et1.getText().toString();
                int oldlength=oldValue.length();
                char lastoperator= oldValue.charAt(oldlength - 1);
                if (lastoperator=='+')
                    ((MainActivity)getActivity()).Addition=false;
                else if (lastoperator=='-')
                    ((MainActivity)getActivity()).Subtract=false;
                else if (lastoperator=='*')
                    ((MainActivity)getActivity()).Multiplication=false;
                else if (lastoperator=='/')
                    ((MainActivity)getActivity()).Division=false;
                else if (lastoperator=='^')
                    ((MainActivity)getActivity()).power=false;
                else if (lastoperator=='\u221A')
                    ((MainActivity)getActivity()).root=false;
                else if (lastoperator=='\u03C0')
                    ((MainActivity)getActivity()).pi=false;
                else if (lastoperator=='e')
                    ((MainActivity)getActivity()).exponent=false;
                String newValue=oldValue.substring(0, oldlength - 1);

                ((MainActivity)getActivity()).et1.setText(newValue);
                //et1.setText(et1.getText()+".");
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
  //                  + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
    public float infixtopostfix(String args) {
        Scanner s = new Scanner(args);
        String infix,str="";
        String next;
        infix = s.next();
        Stack<String> st=new Stack<String>();
        ArrayList<String> al=new ArrayList<String>();
        //	ArrayDeque<Character> q=new ArrayDeque<Character>();
        int m;

        for(int i=0;i<infix.length();i++)
        {
            String symbol=infix.substring(i, i + 1);

            if(symbol!=" ")
            {
		/*m=(int)symbol;
		if((m>=48)&&(m<=57)){
			al.add(symbol);
		//	al.add(symbol);
			}*/

                switch(symbol)
                {
                    case "(":
                        al.add(str);
                        str="";
                        st.push(symbol);break;

                    case ")":
                        al.add(str);
                        str="";
                        while((next=st.pop())!="(")
                        {
                            al.add(next);
                        }
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                    case "%":
                    case "^":
                        al.add(str);
                        str="";
                        while((!st.empty())&&(priority1(symbol)<=priority1(st.peek())))
                        {
                            al.add(st.pop());
                        }
                        st.push(symbol);
                        break;
                    default:
                        str=str+symbol;
                }



            }

        }



        al.add(str);

        str="";
        while(!st.empty())
        {

            al.add(st.pop());
        }

        String str1="";

        String a[]=new String[al.size()];
        a=al.toArray(a);
        for(String i:a)
            str1=str1+i+" ";

        //System.out.println(str1);
        float result;
        result=evalPf(str1);
        return result;
//System.out.println(result);
    }
    static float evalPf(String str)
    {
        //Scanner scr=new Scanner(str);
        // str=str.replaceAll("\\s+"," ");
        Scanner scr=new Scanner(str);
        Stack<Float> stack = new Stack<Float>();

        while (scr.hasNext()) {
            if (scr.hasNextFloat()) {
                stack.push(scr.nextFloat());
                continue;
            }
            float b = stack.pop();
            float a = stack.pop();

            char op = scr.next().charAt(0);
            if      (op == '+') stack.push(a+b);
            else if (op == '-') stack.push(a - b);
            else if (op == '*') stack.push(a * b);
            else if (op == '/') stack.push(a / b);
            else if (op == '%') stack.push(a % b);

        }
        //sc.close();
        return stack.pop();
    }//
    //
//
//
//
    static	int priority1(String c)
    {
        switch(c)
        {
            case"(":return 0;

            case "+":
            case "-":
                return 1;

            case "*":
            case"/":
            case "%":
                return 2;
            case"^":
                return 3;
            default:return 0;
        }
    }
}
