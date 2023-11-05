import java.awt.event.*;

class Animation extends Methodenbox
{
    void Starten()
    {
    while(QuizPunkte== -1)
    {
        fuegeTextHinzu("StartText", "Drücke eine Taste, um zu Starten", 200, 200, 300, 20);
        warte(2);
        entferneText("StartText");
        warte(2);
    }
    }
    int screenNummer; 
    
    
    void zeigeFrage1()
    {
        fuegeTextHinzu("QuizPunkte ","Deine Punkte: ", 200, 50, 300, 20);
        fuegeTextHinzu("Frage","In einem Computer gibt es" , 200, 100, 300, 20);
        fuegeTextHinzu("Antwort1","Tippe a für: Chips" , 200, 150, 300, 20);
        fuegeTextHinzu("Antwort2","Tippe b für: Dips" , 200, 200, 300, 20);
        fuegeTextHinzu("Antwort3","Tippe c für: Flips" , 200, 250, 300, 20);
        QuizPunkte = QuizPunkte + 1;
        
        
        screenNummer = 1;
        
    }
    
    void PunkteLoss()
    {
        if (QuizPunkte >=1)
                {
                    QuizPunkte = QuizPunkte -1;
                }
                else 
                {
                   QuizPunkte = QuizPunkte; 
                }
    }
    
    void PunkteGain()
    {
        if (QuizPunkte >=1)
                {
                    QuizPunkte = QuizPunkte +1;
                }
    }
    void zeigeAntwort1()
    {
        screenNummer = 2;
    }

            
    void zeigeFrage2()
    {
        ersetzeText("QuizPunkte ","-");
        ersetzeText("Frage", "Frage 2...");
        fuegeTextHinzu("Antwort1", "...", 200, 150, 200, 20);
        fuegeTextHinzu("Antwort2", "...", 200, 200, 200, 20);
        fuegeTextHinzu("Antwort3", "...", 200, 250, 200, 20);
    }
    
    
    public int OuizPunkte; 
    public int QuizPunkte = -1;
        
    
    @Override public void keyReleased(KeyEvent e)
    {
        char buchstabe;
        buchstabe = e.getKeyChar();
        if(screenNummer == 1)
        {
            if(buchstabe == 'a')
            {
                ersetzeText("Antwort1", "Drücke n Für die Nächste Frage");
                entferneText("Antwort2");
                entferneText("Antwort3");
                ersetzeText("Frage" , "Diese Antort ist Richtig");
                PunkteGain();
            }
            if(buchstabe == 'b')
            {
               entferneText("Antwort1");
               entferneText("Antwort2");
               entferneText("Antwort3");
               ersetzeText("Frage" , "Diese Antort ist Flasch, richtig wäre a");
               PunkteLoss();
            }
            if(buchstabe == 'c')
            {
               entferneText("Antwort1");
               entferneText("Antwort2");
               entferneText("Antwort3");
               ersetzeText("Frage" , "Diese Antort ist Flasch, richtig wäre a");
               PunkteLoss();
            }
            zeigeAntwort1();
        }
        else
        {
            if(screenNummer == 2)
            {
                zeigeFrage2();
            }
        }
        
        if(buchstabe == buchstabe)
        {
               zeigeFrage1();
            }

    }
  
}
