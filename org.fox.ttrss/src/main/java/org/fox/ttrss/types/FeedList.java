package org.fox.ttrss.types;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class FeedList extends ArrayList<Feed> implements Parcelable {

		public FeedList() { }
	
		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel out, int flags) {
			out.writeList(this);
		}
		
		public void readFromParcel(Parcel in) {
			in.readList(this, getClass().getClassLoader());			
		}
				
		public FeedList(Parcel in) {
			readFromParcel(in);
		}
		
		@SuppressWarnings("rawtypes")
		public static final Parcelable.Creator CREATOR =
	    	new Parcelable.Creator() {
	            public FeedList createFromParcel(Parcel in) {
	                return new FeedList(in);
	            }
	 
	            public FeedList[] newArray(int size) {
	                return new FeedList[size];
	            }
	        };
	}
