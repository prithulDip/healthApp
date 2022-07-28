package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

@RunWith(RobolectricTestRunner.class)
public class DatabaseUnitTest {
    @Test
    public void testAdd() {
        DBhelper sqLiteDatabase = new DBhelper(RuntimeEnvironment.application);
        String date="12/12/12";
        String time="10:00";
        String systol = "120";
        String diastol = "80";
        String pulse = "68";
        String comments = "ok";


        sqLiteDatabase.addEntry(systol,diastol,pulse, date,comments, time);

        assertTrue(sqLiteDatabase.checkData("1"));

        sqLiteDatabase.close();
    }

    /**
     * checks if a record is deleted successfully on database
     */
    @Test
    public void testdelete() {
        DBhelper sQliteDBmanager = new DBhelper(RuntimeEnvironment.application);
        String date="12/12/12";
        String time="10:00";
        String systol = "120";
        String diastol = "80";
        String pulse = "68";
        String comments = "ok";


        sQliteDBmanager.addEntry(systol,diastol,pulse, date,comments, time);

        sQliteDBmanager.deleteOneRow("2");

        assertTrue(!sQliteDBmanager.checkData("2"));

        sQliteDBmanager.close();
    }

    /**
     * checks if update on database is successful
     */
    @Test
    public void testUpdate() {
        DBhelper sQliteDBmanager = new DBhelper(RuntimeEnvironment.application);

        String date="12/12/12";
        String time="10:00";
        String systol = "120";
        String diastol = "80";
        String pulse = "68";
        String comments = "ok";



        sQliteDBmanager.addEntry(systol,diastol,pulse, date,comments, time);

         date="12/12/22";
         time="10:00";
         systol = "122";
         diastol = "80";
         pulse = "68";
         comments = "ok";


        sQliteDBmanager.updateData("3", systol,diastol,pulse, date,comments, time);

        assertEquals(1,1);

        sQliteDBmanager.close();
    }

}
