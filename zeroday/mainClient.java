package zeroday;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import zeroday.events.mainEvent;
import zeroday.modules.mainModule;
import zeroday.modules.mainModule.Category;
import zeroday.movement.*;
import zeroday.player.*;
import zeroday.render.*;
import zeroday.ui.*;

public class mainClient {

	public static String name = "ZeroDay", version = "0.1";
	public static CopyOnWriteArrayList<mainModule> modules = new CopyOnWriteArrayList<mainModule>();
	public static HUD hud = new HUD();
	
	public static void startup() {
		System.out.println("Starting ZeroDay...");
		
		modules.add(new Fly());
		modules.add(new Sprint());
		modules.add(new FullBright());
		modules.add(new NoFall());
		modules.add(new TestModule());
		modules.add(new AdvanceView());
	}
	
	
	public static void onEvent(mainEvent e) {
		for(mainModule m: modules) {
			if(!m.toggled)
				continue;
			
			m.onEvent(e);
		}
	}
	
	public static void keyPress(int key) {
		for(mainModule m: modules) {
			if(m.getKey() == key) {
				m.toggle();
			}
		}
	}
	
	public List<mainModule> getModulesByCategory(Category c){
		List<mainModule> modules = new ArrayList<mainModule>();
		
		for(mainModule m : this.modules) {
			if(m.category == c)
				modules.add(m);
		}
		
		return modules;
	}
}
