package modelo;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica implements Comunicación.OnMessageListener{
	Comunicación com;
	Conejo conejo;
	Tortuga tortuga;
	PApplet p;
	PImage fondo, ganoC, ganoT, perdioC, perdioT;
	float x, y;
	int contador;

	public Logica(PApplet p) {
		this.conejo = new Conejo(30, 300, p);
		this.tortuga = new Tortuga(30, 400, p);
		fondo = p.loadImage("imagenes/fondo.png");
		ganoC = p.loadImage("imagenes/ganoC.png");
		ganoT = p.loadImage("imagenes/ganoT.png");
		perdioC = p.loadImage("imagenes/perdioC.png");
		perdioT = p.loadImage("imagenes/perdioT.png");
		this.x = 0;
		this.y = 0;
		this.contador = 0;
	}

	public void comunicacion() {
		com = new Comunicación(this);
		com.setObserver(this);
		com.esperarConexion();

	}

	public void pintar(PApplet p) {
		p.image(fondo, x, y, 3599, 500);

		if (p.frameCount % 10 == 0) {
			contador++;

		}
		if (contador >= 1 && contador <= 32) {
			this.x -= 10;
		}
		if (contador == 32) {
			this.x = -3100;
		}
		tortuga.pintar(p);
		conejo.pintar(p);

		if (conejo.X >= 500) {

			p.image(ganoC, 0, 0);
		}

		if (conejo.X <= 0) {

			p.image(perdioC, 0, 0);
		}
		if (tortuga.X >= 500) {

			p.image(ganoT, 0, 0);
		}
		if ( tortuga.X <=0) {

			p.image(perdioT, 0, 0);
		}

	}

	public void estamina(PApplet p) {

		conejo.recargarEstamina(p);

	}

	public void mover(PApplet p) {
		conejo.mover(p);
		
	}
	
	
	

	@Override
	public void onMessage(String mensaje) {
		// TODO Auto-generated method stub
		if(mensaje.startsWith("POS")) {
			String[] direccion = mensaje.split("::");
			p.printArray(direccion);
			tortuga.mover(direccion[1]);
		}
		if(mensaje.startsWith("POS")) {
			String[] recarga = mensaje.split("::");
			p.printArray(recarga);
			tortuga.recargarEstamina(recarga[1]);
		}
	}
	
	
	
	
}