package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Driver {
	public static void main(String[] args) throws NoSuchFieldException {
		GetGenericType<Cat> genClass = new GetGenericType<>();
/*
		Type superclassType = genClass.getClass().getGenericSuperclass();

		Class fieldArgClass = (Class) superclassType;
		System.out.println("fieldArgClass = " + fieldArgClass);

		Class claxx = ((Class) ((ParameterizedType) genClass.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
		System.out.println(claxx);*/
		Field field = genClass.getClass().getField("type");
		System.out.println(((ParameterizedType) field.getDeclaringClass().getGenericSuperclass()).getActualTypeArguments()[0]);
				/*if (!ParameterizedType.class.isAssignableFrom(superclassType.getClass())) {

		}
		System.out.println(((ParameterizedType)superclassType).getActualTypeArguments()[0]);
*///		System.out.println(type);
	}

}
