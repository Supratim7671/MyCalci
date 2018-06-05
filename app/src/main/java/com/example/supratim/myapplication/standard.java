package com.example.supratim.myapplication;

import android.app.Activity;
import java.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.content.Intent;
import java.util.Locale;
import android.widget.Toast;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class standard extends Fragment implements OnInitListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19,b20;
    private TextToSpeech myTTS;
    //status check code
    private int MY_DATA_CHECK_CODE = 0;
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
     * @return A new instance of fragment Scientific.
     */
    // TODO: Rename and change types and number of parameters
    public static standard newInstance(String param1, String param2) {
        standard fragment = new standard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public standard() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Intent checkTTSIntent = new Intent();
        checkTTSIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scientific, container, false);
        b1 = (Button) view.findViewById(R.id.bt1);
        b2 = (Button) view.findViewById(R.id.bt2);
        b3 = (Button) view.findViewById(R.id.bt3);
        b4 = (Button) view.findViewById(R.id.bt4);
        b5 = (Button) view.findViewById(R.id.bt5);
        b6 = (Button) view.findViewById(R.id.bt6);
        b7 = (Button) view.findViewById(R.id.bt7);
        b8 = (Button) view.findViewById(R.id.bt8);
        b9 = (Button) view.findViewById(R.id.bt9);
        b10 = (Button) view.findViewById(R.id.bt10);
        b11 = (Button) view.findViewById(R.id.bt11);
        b12 = (Button) view.findViewById(R.id.bt12);
        b13 = (Button) view.findViewById(R.id.bt13);
        b14 = (Button) view.findViewById(R.id.bt14);
        b15 = (Button) view.findViewById(R.id.bt15);
        b16 = (Button) view.findViewById(R.id.bt16);
        b17 = (Button) view.findViewById(R.id.bt17);
        b18 = (Button) view.findViewById(R.id.bt18);
        b19 = (Button) view.findViewById(R.id.bt19);
        b20 = (Button)view.findViewById(R.id.bt20);
        //listen for clicks
        b20.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {
                String words = ((MainActivity)getActivity()).et1.getText().toString();
                speakWords(words);
            }
        });


        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((MainActivity) getActivity()).Addition == true||((MainActivity) getActivity()).Division == true||((MainActivity) getActivity()).Subtract == true||((MainActivity) getActivity()).Multiplication == true) {
                    String second = ((MainActivity) getActivity()).et1.getText().toString();
                     //second=String.valueOf(String.format("%0.4f",second));
                    float result1;String fourth;
                    if (second.charAt(0)=='-') {
                         result1 = (-1)*infixtopostfix(second.substring(1));
                         fourth=String.valueOf(String.format("%.4f",result1));
                    }
                        else {
                        result1 = infixtopostfix(second);
                         fourth=String.valueOf(String.format("%.4f",result1));
                    }
                        ((MainActivity) getActivity()).et1.setText(second + "="+fourth+"");
                }
                //  ValueTwo = Float.parseFloat(et1.getText() + "");

//                if (((MainActivity)getActivity()).Addition == true){
//                    String second=((MainActivity)getActivity()).et1.getText().toString();
//                    ((MainActivity) getActivity()).ValueOne=Float.parseFloat(second.substring(0, second.lastIndexOf('+') )+"");
//                    ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(second.substring(second.lastIndexOf('+')+1)+"");
//                    ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).ValueOne + ((MainActivity)getActivity()).ValueTwo +"");
//                    ((MainActivity)getActivity()).Addition=false;
//                }
//
//
//                if (((MainActivity)getActivity()).Subtract == true){
//                    String second=((MainActivity)getActivity()).et1.getText().toString();
//                    ((MainActivity)getActivity()).ValueOne=Float.parseFloat(second.substring(0, second.lastIndexOf('-') )+"");
//                    ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(second.substring(second.lastIndexOf('-')+1)+"");
//                    ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).ValueOne - ((MainActivity)getActivity()).ValueTwo+"");
//                    ((MainActivity)getActivity()).Subtract=false;
//                }
//
//                if (((MainActivity)getActivity()).Multiplication == true){
//                    String second=((MainActivity)getActivity()).et1.getText().toString();
//                    ((MainActivity)getActivity()).ValueOne=Float.parseFloat(second.substring(0,second.lastIndexOf('*'))+"");
//                    ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(second.substring(second.lastIndexOf('*')+1)+"");
//
//                    String str=String.valueOf(String.format("%.4f",((MainActivity)getActivity()).ValueOne * ((MainActivity)getActivity()).ValueTwo));
//
//
////
//// if (str.contains("E")) {
////                       String str1 = str.substring(0, str.lastIndexOf('E'));
////                       String str2 = str.substring(str.lastIndexOf('E') + 1);
////                        String st =  "10^" + str2+ "*" + str1;
////                        ((MainActivity) getActivity()).et1.setText(st + "");
////                       // Log.e("value1",st);
////
////                    }
////                    else
//                        ((MainActivity)getActivity()).et1.setText(str+"");
//                    ((MainActivity)getActivity()).Multiplication=false;
//                }
//
//                if (((MainActivity)getActivity()).Division == true){
//                    String second=((MainActivity)getActivity()).et1.getText().toString();
//                    ((MainActivity)getActivity()).ValueOne=Float.parseFloat(second.substring(0,second.lastIndexOf('/'))+"");
//                    ((MainActivity)getActivity()).ValueTwo=Float.parseFloat(second.substring(second.lastIndexOf('/') + 1)+"");
//                    ((MainActivity)getActivity()).et1.setText(((MainActivity)getActivity()).ValueOne / ((MainActivity)getActivity()).ValueTwo+"");
//                    ((MainActivity)getActivity()).Division=false;
//                }
            }
        });

        if ((((MainActivity) getActivity()).Addition != true) || (((MainActivity) getActivity()).Subtract != true) || (((MainActivity) getActivity()).Multiplication != true) || (((MainActivity) getActivity()).Division != true)) {

            b12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (((MainActivity) getActivity()).et1 == null) {
                        ((MainActivity) getActivity()).et1.setText("");
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

            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (((MainActivity) getActivity()).et1 == null) {
                        ((MainActivity) getActivity()).et1.setText("");
                    } else {
                        //ValueOne = Float.parseFloat(et1.getText() + "");
                        ((MainActivity) getActivity()).Subtract = true;

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
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (((MainActivity) getActivity()).et1 == null) {
                        ((MainActivity) getActivity()).et1.setText("");
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
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  char temp=' ',prop;
                    if (((MainActivity) getActivity()).et1 == null) {
                        ((MainActivity) getActivity()).et1.setText("");
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
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "7");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "8");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "9");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "4");
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "5");
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "6");
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "1");
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "2");
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "3");
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + "0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText("");
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ((MainActivity) getActivity()).et1.setText(((MainActivity) getActivity()).et1.getText() + ".");
            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                float value = Float.parseFloat(((MainActivity) getActivity()).et1.getText().toString()) / 100;
                ((MainActivity) getActivity()).et1.setText(value + "");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String oldValue = ((MainActivity) getActivity()).et1.getText().toString();
                int oldlength = oldValue.length();
                char lastoperator = oldValue.charAt(oldlength - 1);
                if (lastoperator == '+')
                    ((MainActivity) getActivity()).Addition = false;
                else if (lastoperator == '-')
                    ((MainActivity) getActivity()).Subtract = false;
                else if (lastoperator == '*')
                    ((MainActivity) getActivity()).Multiplication = false;
                else if (lastoperator == '/')
                    ((MainActivity) getActivity()).Division = false;

                String newValue = oldValue.substring(0, oldlength - 1);
                ((MainActivity) getActivity()).et1.setText(newValue);
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
///            throw new ClassCastException(activity.toString()
            //                + " must implement OnFragmentInteractionListener");
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
    //speak the user text
    private void speakWords(String speech) {

        //speak straight away
        myTTS.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
    }
    //act on result of TTS data check
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                //the user has the necessary data - create the TTS
                myTTS = new TextToSpeech(((MainActivity) getActivity()),this );
            }
            else {
                //no data - install it now
                Intent installTTSIntent = new Intent();
                installTTSIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        }
    }
    public void onInit(int initStatus) {

        //check for successful instantiation
        if (initStatus == TextToSpeech.SUCCESS) {
            if(myTTS.isLanguageAvailable(Locale.US)==TextToSpeech.LANG_AVAILABLE)
                myTTS.setLanguage(Locale.US);
        }
        else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(((MainActivity) getActivity()), "Sorry! Text To Speech failed...", Toast.LENGTH_LONG).show();

        }
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
        // TODO code application logic here
    }
