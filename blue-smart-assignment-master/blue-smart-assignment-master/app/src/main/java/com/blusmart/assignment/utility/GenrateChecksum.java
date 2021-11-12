package com.blusmart.assignment.utility;

import android.util.Log;

import org.mindrot.jbcrypt.BCrypt;

public class GenrateChecksum {


    public static String checksumForDutyId(String id) {
        String hash = Constants.PRIVATE_STRING + ",/api/v1/app/duty/" + id;
        return BCrypt.hashpw(hash, BCrypt.gensalt(12));
    }

    public String checksumForList() {
        String hash = Constants.PRIVATE_STRING + ",/api/v1/app/dutyid/list";
        return BCrypt.hashpw(hash, BCrypt.gensalt(12));
    }

    public static String checksumForUpdateDuty(String id, String action, String assigned, double latitude, double longitude, long timestamp, String user) {

        /*bluPriv@8,START,BLU-SMART,23.333,25.332,1496982995000,/api/v1/app/update/duty/4356,puneet*/
        String hash = Constants.PRIVATE_STRING + "," + action + ","
                + assigned + "," + latitude + "," + longitude + "," + timestamp
                + ",/api/v1/app/update/duty/" + id + "," + user;

        Log.e("this", "Hash :::" + hash);

        return BCrypt.hashpw(hash, BCrypt.gensalt(12));
    }
}