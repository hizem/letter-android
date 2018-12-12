package com.example.hizem.lettre;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data {
    private List<Character> voyelle=new ArrayList<Character>();
    private List<Character> consonne=new ArrayList<Character>();
    private static List<String> dictionnaryEn = new ArrayList<String>();
    private static List<String> dictionnaryFr = new ArrayList<String>();
    public static int scores=0;
    private static Data Instance = new Data();
    private Data(){
        this.voyelle.add('a');
        this.consonne.add('b');
        this.consonne.add('c');
        this.consonne.add('d');
        this.voyelle.add('e');
        this.consonne.add('f');
        this.consonne.add('g');
        this.consonne.add('h');
        this.voyelle.add('i');
        this.consonne.add('j');
        this.consonne.add('k');
        this.consonne.add('l');
        this.consonne.add('m');
        this.consonne.add('n');
        this.voyelle.add('o');
        this.consonne.add('p');
        this.consonne.add('q');
        this.consonne.add('r');
        this.consonne.add('s');
        this.consonne.add('t');
        this.voyelle.add('u');
        this.consonne.add('v');
        this.consonne.add('w');
        this.consonne.add('x');
        this.consonne.add('y');
        this.consonne.add('z');

    }
    public static Data getInstance(){
        return Instance;

    }
    public void addEn(String word){
        dictionnaryEn.add(word);
    }

    public List<String> getDictionnaryEn() {
        return dictionnaryEn;
    }

    public void addFr(String word){
        dictionnaryFr.add(word);
    }

    public List<String> getDictionnaryFr() {
        return dictionnaryFr;
    }


    public Character getConsonne() {
        Random rand= new Random();
        return this.consonne.get(rand.nextInt(this.consonne.size()));
    }


    public Character getVoyelle(){
        Random rand = new Random();
        return this.voyelle.get(rand.nextInt(this.voyelle.size()));}

        public String LargestWordEn(List <Character> list){
            List <String> words = new ArrayList<>();
            String largest="";
            for(String i : dictionnaryEn){
                boolean verif = true;
                for(Character j : list){
                   if( i.indexOf(j)<=0){
                       verif= false;
                   }
                }
                if(verif==true){
                    words.add(i);}
            }

            for(String c : words){
                if(c.length()>largest.length()){
                    largest=c;
                }
            }
        return largest;
    }
    public String LargestWordFr(List <Character> list){
        List <String> words = new ArrayList<>();
        String largest="";
        for(String i : dictionnaryFr){
            boolean verif = true;
            for(Character j : list){
                if( i.indexOf(j)<=0){
                    verif= false;
                }
            }
            if(verif==true){
            words.add(i);}
        }

        for(String c : words){
            if(c.length()>largest.length()){
                largest=c;
            }
        }
        return largest;
    }
}
