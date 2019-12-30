package classes;

import com.example.recruitingsystem.R;

import java.util.HashMap;

public class FragmentMap {

    HashMap<Integer , Integer> viewFragmentMap = new HashMap<>();
    HashMap<Integer , String> FragmentClassMap = new HashMap<>();

    public FragmentMap() {

        /* TODO: (R.id.od_elzorar   ,  R.layout.id_elfragment ) */

        //Main activity buttons
        this.viewFragmentMap.put(R.id.signin , R.layout.fragment_signin );
        this.viewFragmentMap.put(R.id.circle , R.layout.fragment_signup );
        this.viewFragmentMap.put(R.id.backTofirstPage1 , R.layout.fragment_first_page );
        this.viewFragmentMap.put(R.id.backTofirstPage2 , R.layout.fragment_first_page );

        //arrayList used in case u want to get layout names
        this.FragmentClassMap.put(R.layout.fragment_signin , "signin");
        this.FragmentClassMap.put(R.layout.fragment_signup , "signup");
        this.FragmentClassMap.put(R.layout.fragment_first_page , "fragment_first_page");
        this.FragmentClassMap.put(R.layout.fragment_first_page , "sign");




        //Home activity buttons
        this.viewFragmentMap.put(R.id.btnForm , R.layout.fragment_form );


        //arrayList used in case u want to get layout names
        this.FragmentClassMap.put(R.layout.fragment_form , "fragment_form");

    }


    public HashMap<Integer, String> getFragmentClassMap() {
        return FragmentClassMap;
    }


    public HashMap<Integer, Integer> getViewFragmentMap()
    {
        return viewFragmentMap;
    }











    public void setViewFragmentMap(HashMap<Integer, Integer> viewFragmentMap) {
        this.viewFragmentMap = viewFragmentMap;
    }
    public void setFragmentClassMap(HashMap<Integer, String> fragmentClassMap) {
        FragmentClassMap = fragmentClassMap;
    }
}
