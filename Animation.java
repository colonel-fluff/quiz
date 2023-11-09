import java.awt.event.*;

class Animation extends Methodenbox
{
    private int screenNummer = 0;
    private int QuizPunkte = 0;
    private String cPunkte;
    
    void PunkteLoss()
    {
        if (QuizPunkte > 1)
                {
                    QuizPunkte = QuizPunkte - 1;
                }
        else 
                {
                   QuizPunkte = QuizPunkte; 
                }
                
        cPunkte = Integer.toString(QuizPunkte);
        ersetzeText("Punkte", cPunkte);
    }
    
    void PunkteGain()
    {
        if (QuizPunkte >= 0)
                {
                    QuizPunkte = QuizPunkte +  1;
                }

        cPunkte = Integer.toString(QuizPunkte);
        ersetzeText("Punkte", cPunkte);
    }
    
    void zeigeFrage1()
    {
       fuegeTextHinzu("Info","Es geht los! Deine Punkte:" ,  200, 50, 300, 20);
       cPunkte = Integer.toString(QuizPunkte);
    fuegeTextHinzu("Punkte", cPunkte, 200, 100, 300, 20);
        fuegeTextHinzu("Frage","Frage: In einem Computer gibt es..." , 200, 150, 300, 20);
        fuegeTextHinzu("Antwort1","Tippe a für: Chips" , 200, 200, 300, 20);
        fuegeTextHinzu("Antwort2","Tippe b für: Dips" , 200, 250, 300, 20);
        fuegeTextHinzu("Antwort3","Tippe c für: Flips" , 200, 300, 300, 20);
        screenNummer = 1;
    }
    
    void zeigeFrage2()
    {
        ersetzeText("Info", "naechste Frage. Deine Punkte:");
        ersetzeText("Punkte", cPunkte);
        ersetzeText("Frage", "Was ist 1+1?");
        ersetzeText("Antwort1", "tippe 1 für: 1");
        ersetzeText("Antwort2", "tippe 2 für: 2");
        ersetzeText("Antwort3", "tippe 3 für: 3");
        
        screenNummer = 2;
    }
   

    void zeigeFrage3()
    {
        ersetzeText("Info", "letzte Frage. Deine Punkte:");
        ersetzeText("Punkte", cPunkte);
        ersetzeText("Frage", "Warum ist die Banane krumm?");
        ersetzeText("Antwort1", "weil halt: w");
        ersetzeText("Antwort2", "Ja: j");
        ersetzeText("Antwort3", "Velleicht: v");
        fuegeTextHinzu("Ausgang","Waehle b zum beenden", 200, 350, 300, 20);
        screenNummer = 3;
    }

    
    @Override public void keyReleased(KeyEvent e)
    {
        char buchstabe;
        buchstabe = e.getKeyChar();
                        
        if(screenNummer == 1)
        {   
            if(buchstabe == 'a')
            {
                ersetzeText("Info", "Diese Antwort ist Richtig. +1 Punkte");
                PunkteGain();
            }
            else {
                
               ersetzeText("Info", "Diese Antwort ist Falsch. -1 Punkte");
               PunkteLoss();
            }
            
            screenNummer = 2;
            zeigeFrage2();
        }
        
        else if(screenNummer == 2)
            {
            if(buchstabe == '2')
            {
               ersetzeText("Info", "Diese Antwort ist Richtig. +1 Punkte");
               PunkteGain();
            } 
            else {
                
               ersetzeText("Info", "Diese Antwort ist Falsch. -1 Punkte");
               PunkteLoss();
            }
            
            screenNummer = 3;
            zeigeFrage3();
        }
        
        else if(screenNummer == 3)
        {
            if(buchstabe == 'w')
            {
                ersetzeText("Info", "Diese Antwort ist Richtig. +1 Punkte");
                PunkteGain();
            } 
            if(buchstabe == 'b')
            {
               ersetzeText("Info", "Diese Antwort ist Falsch. -1 Punkte");
               PunkteLoss();
            }
            if(buchstabe == 'c')
            {
               ersetzeText("Info", "Diese Antwort ist Falsch. -1 Punkte");
               PunkteLoss();
            }
            if(buchstabe == 'b')
            { System.exit(0); }
        }
    }

    }