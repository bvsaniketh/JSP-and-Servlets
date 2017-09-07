package com.max;

public class Maximum {
	public static int findmax(int arr[])
	{
		int max=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(max<arr[i])
				max=arr[i];
		}
		return max;
	}	
	
	public static int cube(int a)
	{
		return a*a*a;
	}
}
