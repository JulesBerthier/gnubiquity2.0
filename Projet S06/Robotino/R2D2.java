import rec.robotino.com.Bumper;
import rec.robotino.com.Com;
import rec.robotino.com.Motor;
import rec.robotino.com.OmniDrive;

import static java.lang.Math.*;

public class R2D2 implements Runnable
{
    protected final String hostname;
    protected final Com com;
    protected final Motor motor1;
    protected final Motor motor2;
    protected final Motor motor3;
    protected final OmniDrive omniDrive;
    protected final Bumper bumper;

   

    public R2D2(String hostname)
    {
        this.hostname = hostname;
        com = new Com();
        motor1 = new Motor();
        motor2 = new Motor();
        motor3 = new Motor();
        omniDrive = new OmniDrive();
        bumper = new Bumper();
    }

    public void run()
    {
        System.out.println("R2D2 started.");
        
        try
        {
            System.out.println("Initializing...");
            init();
            System.out.println("Connecting...");
            connect(hostname);
            System.out.println("Connected.");
            System.out.println("Driving...");
            instruction()	//@Adrian: ICI on met la sequence d'action a réaliser
			instruction()	// ICI
			instruction()	// ICI
			instruction()	// ICI
			instruction()	// ICI
			instruction()	//  et ICI...
			
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            disconnect();
        }

        System.out.println("Done.");
    }

    protected void init()//@Adrian: On touche pas pour le moment
    {
        motor1.setComId(com.id());
        motor1.setMotorNumber(0);

        motor2.setComId(com.id());
        motor2.setMotorNumber(1);

        motor3.setComId(com.id());
        motor3.setMotorNumber(2);

        omniDrive.setComId(com.id());

        bumper.setComId(com.id());
    }

    protected void connect(String hostname)
    {
        com.setAddress(hostname);
        com.connect();
    }

    protected void disconnect()
    {
        com.disconnect();
    }
	protected void cercle(long tps,float vit,int nbrTour) throws InterruptedException //@Adrian:Voici mon code, le throws nous permet d'interrompre la methode 
    {																				  //@Adrian:a la fin il me semble dans tous les cas il est essentiel ne l'oubliez pas 
        float[] dir;
        float a = 0.0f;
        long startTime = System.currentTimeMillis();//@Adrian:prend l'origine des temps
		float tpssectour=10;						//@Adrian: temps que met le robot a faire un tour en sec
		float tpstour=tpssectour*1000;				//@Adrian:temps que met le robot a faire un tour en ms
        int tpsstop=nbrTour *10000;					//@Adrian:calcul du temps necessaire pour faire x tours en millisecondes
        long elapsedTime=0;							//@Adrian: temps écoulé initialisé à 0 ms
		protected final float[] startVector = new float[]
    {
        200.0f, 0.0f										//@Adrian:A changer après les tests
    };
        while (tps<System.currentTimeMillis() - startTime){
															//@Adrian: Temporisation
        }
       startTime=System.currentTimeMillis();//@Adrian: nouvelle origine des temps quand l'execution commence
        while(tpsstop<System.currentTimeMillis() - startTime){
			long elapsedTime = System.currentTimeMillis() - startTime;
        
            
            dir = rotate(startVector, a);
            a = 360.0f * elapsedTime / 10000;					//@Adrian: là j'ai rien touché je garde le code original

            omniDrive.setVelocity(dir[0], dir[1], 0);

            com.waitForUpdate();
        }
    }
	protected void tourner() throws InterruptedException:{ //@Adrian:A completer!!!!!
														//@Adrian:A completer!!!!!
	}													//@Adrian:A completer!!!!!
	protected void avAr()throws InterruptedException{	//@Adrian:A completer!!!!!
														//@Adrian:A completer!!!!!
	}													//@Adrian:A completer!!!!!
	protected void avancer()throws InterruptedException{
														//@Adrian:A completer!!!!!	
	}													//@Adrian:A completer!!!!!
	protected void cote()throws InterruptedException{
														//@Adrian:A completer!!!!!	
	}													//@Adrian:A completer!!!!!
	
	private float[] rotate(float[] in, float deg)		//@Adrian:permet de determiner la vitesse necessaire pour continuer la trajectoire circulaire

    {
        final float pi = 3.14159265358979f;

        float rad = 2 * pi / 360.0f * deg;

        float[] out = new float[2];
        out[0] = (float) (cos(rad) * in[0] - sin(rad) * in[1]);
        out[1] = (float) (sin(rad) * in[0] + cos(rad) * in[1]);
        return out;
    }

}
