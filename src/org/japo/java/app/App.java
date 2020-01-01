/*
 * Copyright 2019 mon_mo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.app;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final Scanner SCN
            = new Scanner(System.in, "UTF-8")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");
    
    public final void launchApp() {
        Random rnd = new Random();
        
        int eligePalabra;
        int random;
        
        String adivinaPalabra;
        String resultado = "";
        String respuesta;

        String[] palabras = {"tubérculo", "patata", "zahanoria",
            "mandarinas", "kebab", "sandía", "peine", "altavoz", 
            "cuchara", "madalena", "turrón", "pacharán", "confeti"};

        eligePalabra = (int) Math.floor(Math.random() * (palabras.length));
        adivinaPalabra = palabras[eligePalabra];
        String marcador = adivinaPalabra;

        //mezcla palabra
        for (int i = adivinaPalabra.length(); i >= 1; i--) {
            random = (int) (Math.random() * i + 1);
            resultado = resultado + adivinaPalabra.substring(random - 1, random);
            adivinaPalabra = adivinaPalabra.substring(0, random - 1) + 
                    adivinaPalabra.substring(random, i);
        }
        //y muestra el resultado mezclado...
        System.out.println(resultado);
        //El resto es historia. Desarrollar al gusto.
        System.out.println();
        System.out.println("Endivinal'o el cacau eixe: ");
        respuesta = SCN.nextLine();
        
        if(respuesta.equals(marcador)) {
            System.out.println("Olé!");
        } else {
            System.out.println("lhas cagat");
        }
    }
}
