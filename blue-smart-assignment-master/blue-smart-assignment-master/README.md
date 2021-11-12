# BLU Smart #
This Project Show list of duties  and Update Duties 

### Build Configuration ###
	This project was build on JDK 1.8.0
    compileSdkVersion 28
    minSdkVersion 16
    targetSdkVersion 28
	

### AndroidMainfest Permission 
	
#### Internet ####
     
	 <uses-permission android:name="android.permission.INTERNET" />
	
#### Location ####
   
  	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />



### Dependencies Used###

#### Butterknife ####

    implementation 'com.jakewharton:butterknife:8.8.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
	Butterknife is used to Bind the view with activity/fragments.
	

#### Recyclerview ####

    implementation 'com.android.support:recyclerview-v7:28.0.0'
	REcyclerview is used for Showing List 
	
	
#### Location ####

	 implementation 'com.github.delight-im:Android-SimpleLocation:v1.0.1'
 
#### bcrypt ####

    implementation group: 'org.mindrot', name: 'jbcrypt', version: '0.3m'


#### Retrofit ####
    implementation 'com.squareup.retrofit2:retrofit:2.4.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.4.1'
    implementation 'com.squareup.retrofit2:converter-gson:3.4.1'
    implementation 'com.squareup.retrofit2:adapter-rxjava:2.4.0'
    implementation 'io.reactivex:rxandroid:1.1.0'



#### Dagger ####
    implementation 'com.google.dagger:dagger:2.14.1'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.14.1'


#### Lint 
		
	Android Lint is used to scans Android project sources for potential bugs. 
	Lint configuration can be found in build.gradle file:
	lintOptions {
    abortOnError true
    checkAllWarnings true
    warningsAsErrors true
	}
