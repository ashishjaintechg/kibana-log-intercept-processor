package test.ashishjaintechg.jpa;

public class KibanaThreadLocal {

private KibanaThreadLocal() {
}

private static ThreadLocal<KibanaLogParams> thLocal = new ThreadLocal<>();


public static void setValue(KibanaLogParams logger){
thLocal.set(logger);
}


public static KibanaLogParams getValue(KibanaLogParams kibanaLogParams){
return thLocal.get();
}

public static void unset(){
thLocal.remove();
 }
}