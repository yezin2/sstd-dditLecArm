package homework;

public class Assign1_Planet {
	public static void main(String[] args) {
		Planet mercury = Planet.수성;
		Planet venus = Planet.금성;
		Planet earth = Planet.지구;
		Planet mars = Planet.화성;
		Planet jupiter = Planet.목성;
		Planet saturn = Planet.토성;
		Planet uranus = Planet.천왕성;
		Planet nepture = Planet.해왕성;
		
		System.out.println("***********************태양계 행성***********************");
		System.out.println(mercury.name() +"의 반지름 : "+ mercury.getNum() + "km");
		System.out.println(mercury.name() +"의 겉넓이 : "+ (double)(mercury.getSfarea()) + "km");
		System.out.println("------------------------------------------------------");
		System.out.println(venus.name() +"의 반지름 : "+ venus.getNum() + "km");
		System.out.println(venus.name() +"의 겉넓이 : "+ (double)(venus.getSfarea()) + "km");
		System.out.println("------------------------------------------------------");
		System.out.println(earth.name() +"의 반지름 : "+ earth.getNum() + "km");
		System.out.println(earth.name() +"의 겉넓이 : "+ (double)(earth.getSfarea()) + "km");
		System.out.println("------------------------------------------------------");
		System.out.println(mars.name() +"의 반지름 : "+ mars.getNum() + "km");
		System.out.println(mars.name() +"의 겉넓이 : "+ (double)(mars.getSfarea()) + "km");
		System.out.println("------------------------------------------------------");
		System.out.println(jupiter.name() +"의 반지름 : "+ jupiter.getNum() + "km");
		System.out.println(jupiter.name() +"의 겉넓이 : "+ (double)(jupiter.getSfarea()) + "km");
		System.out.println("------------------------------------------------------");
		System.out.println(saturn.name() +"의 반지름 : "+ saturn.getNum() + "km");
		System.out.println(saturn.name() +"의 겉넓이 : "+(double)(saturn.getSfarea()) + "km");
		System.out.println("------------------------------------------------------");
		System.out.println(uranus.name() +"의 반지름 : "+ uranus.getNum() + "km");
		System.out.println(uranus.name() +"의 겉넓이 : "+ (double)(uranus.getSfarea()) + "km");
		System.out.println("------------------------------------------------------");
		System.out.println(nepture.name() +"의 반지름 : "+ nepture.getNum() + "km");
		System.out.println(nepture.name() +"의 겉넓이 : "+ (double)(nepture.getSfarea()) + "km");
		System.out.println("------------------------------------------------------");
		
	}
	public enum Planet{
		수성(2439), 금성(6052), 지구(6371), 화성(3390),목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);
		
		private double num;
		
		Planet(double data){
			num = data;
		}
		
		public double getNum() {
			return num;
		}
		
		public double getSfarea() {
			return Math.pow(num, 2)*3.14*4;
		}
	}
}
