package com.tute.pulltorefresh.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.example.first.R;
import com.tute.pulltorefresh.activity.MyListView.OnRefreshListener;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.app.Activity;


public class MainActivity extends Activity {
	String mStrings;
	private LinkedList<ArrayList<HashMap<String, String>>> mList = new LinkedList<ArrayList<HashMap<String, String>>>();
	private ArrayList<HashMap<String,String>> mGist1 = new ArrayList<HashMap<String,String>>();	
	ArrayList<HashMap<String,String>> mGist2 = new ArrayList<HashMap<String,String>>();
	ListViewAdapter adapter;
	private MyListView mPullRefreshListView;
	public static String[] thumbImageUrls = new String[] {
		"http://d.hiphotos.baidu.com/album/w%3D2048/sign=14b0934b78310a55c424d9f4837d42a9/a8014c086e061d95e9fd3e807af40ad163d9cacb.jpg",
		"http://c.hiphotos.bdimg.com/album/s%3D900%3Bq%3D90/sign=b8658f17f3d3572c62e290dcba28121a/5fdf8db1cb134954bb97309a574e9258d0094a47.jpg",
		"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=ccd33b46d53f8794d7ff4b26e2207fc9/0d338744ebf81a4c0f993437d62a6059242da6a1.jpg",
		"http://c.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=cdab1512d000baa1be2c44b3772bc82f/91529822720e0cf3855c96050b46f21fbf09aaa1.jpg",
		"http://g.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=e58fb67bc8ea15ce45eee301863b4bce/a5c27d1ed21b0ef4fd6140a0dcc451da80cb3e47.jpg",
		"http://f.hiphotos.bdimg.com/album/s%3D680%3Bq%3D90/sign=6b62f61bac6eddc422e7b7f309e0c7c0/6159252dd42a2834510deef55ab5c9ea14cebfa1.jpg", };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPullRefreshListView = (MyListView)findViewById(R.id.pull_refresh_list);		
		initData();		
		mList.add(mGist1);		
		adapter = new ListViewAdapter(this, mList);
		mPullRefreshListView.setAdapter(adapter);
		mPullRefreshListView.setonRefreshListener(new OnRefreshListener() {		
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				new AsyncTask<Void, Void, Void>() {
					// 运行在UI线程中，在调用doInBackground()之前执行
					protected void onPostExecute(Void result) {
						adapter.notifyDataSetChanged();
						mPullRefreshListView.onRefreshComplete();
					}
					// 后台运行的方法，可以运行非UI线程，可以执行耗时的方法
					protected Void doInBackground(Void... params) {
						try {
							Thread.sleep(2000);
						} catch (Exception e) {
							e.printStackTrace();
						}	
						getData();
						mList.addFirst(mGist2);
						return null;
					}					
				}.execute();
			}
		});

	}
	
	private void getData() {
		// TODO Auto-generated method stub
		HashMap<String, String> map = new HashMap<String, String>();	    
	    map.put("image",thumbImageUrls[0] );
	    map.put("name", "你");
	    map.put("grade", "在这里我就是最棒的谁能更我比。哈哈哈~");
	    mGist2.add(map);
	    
	    map = new HashMap<String, String>();
	    map.put("image", thumbImageUrls[1]);
	    map.put("name", "我");
	    map.put("grade", "在这里我就是最棒的谁能更我比。哈哈哈~");
	    mGist2.add(map);
	    
	    map = new HashMap<String, String>();
	    map.put("image", thumbImageUrls[2]);
	    map.put("name", "她");
	    map.put("grade", "在这里我就是最棒的谁能更我比。哈哈哈~");
	    mGist2.add(map);	    	   

	    map = new HashMap<String, String>();
	    map.put("image",thumbImageUrls[3]);
	    map.put("name", "你们");
	    map.put("grade", "在这里我就是最棒的谁能更我比。哈哈哈~");
	    mGist2.add(map);
	    
	    map = new HashMap<String, String>();
	    map.put("image", thumbImageUrls[4]);
	    map.put("name", "我们");
	    map.put("grade", "在这里我就是最棒的谁能更我比。哈哈哈~");
	    mGist2.add(map);
	    
	    map = new HashMap<String, String>();
	    map.put("image", thumbImageUrls[5]);
	    map.put("name", "他们");
	    map.put("grade", "在这里我就是最棒的谁能更我比。哈哈哈~");
	    mGist2.add(map);
	}
	
	public void initData(){
		//ArrayList<HashMap<String,Integer>> array =new ArrayList<HashMap<String,Integer>>();
	    HashMap<String, String> map = new HashMap<String, String>();	    
	    map.put("image",thumbImageUrls[1] );
	    map.put("name", "你");
	    map.put("grade", "IT民工话费卡首付款后烧开后冯绍峰到合肥进口商");
	    mGist1.add(map);
	    
	    map = new HashMap<String, String>();
	    map.put("image", thumbImageUrls[1]);
	    map.put("name", "我");
	    map.put("grade", "IT民工话费卡首付款后烧开后冯绍峰到合肥进口商");
	    mGist1.add(map);
	    
	    map = new HashMap<String, String>();
	    map.put("image", thumbImageUrls[1]);
	    map.put("name", "她");
	    map.put("grade", "IT民工话费卡首付款后烧开后冯绍峰到合肥进口商");
	    mGist1.add(map);	    
	    map = new HashMap<String, String>();
	    map.put("image", thumbImageUrls[1]);
	    map.put("name", "你们");
	    map.put("grade", "IT民工话费卡首付款后烧开后冯绍峰到合肥进口商");
	    mGist1.add(map);
	    
	    map = new HashMap<String, String>();
	    map.put("image", thumbImageUrls[1]);
	    map.put("name", "我们");
	    map.put("grade", "IT民工话费卡首付款后烧开后冯绍峰到合肥进口商");
	    mGist1.add(map);
	    
	    map = new HashMap<String, String>();
	    map.put("image", thumbImageUrls[1]);
	    map.put("name", "他们");
	    map.put("grade", "IT民工话费卡首付款后烧开后冯绍峰到合肥进口商");
	    mGist1.add(map);		
	}     	  

}
