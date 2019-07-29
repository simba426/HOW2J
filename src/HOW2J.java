import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import reflection.*;

public class HOW2J {

    public static void main(String[] argv) {
        File f = new File("/Users/simba/git/HOW2J/src/hero.config");
        try (FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr); ) {
            String line1 = br.readLine().trim();
            String line2 = br.readLine().trim();
            String line3 = br.readLine().trim();
            String line4 = br.readLine().trim();
            //System.out.println(line1);
            Class gclass = Class.forName(line1);
            Constructor gc = gclass.getConstructor();
            ADHero garen = (ADHero) gc.newInstance();
            Class tclass = Class.forName(line3);
            Constructor tc = tclass.getConstructor();
            APHero teemo = (APHero) tc.newInstance();

            Hero h = new Hero();

            Field gf = h.getClass().getDeclaredField("name");
            gf.set(garen, line2);
            Field tf = h.getClass().getDeclaredField("name");
            tf.set(teemo, line4);

            Method m = h.getClass().getDeclaredMethod("attackHero", Hero.class);
            m.invoke(garen, teemo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}







