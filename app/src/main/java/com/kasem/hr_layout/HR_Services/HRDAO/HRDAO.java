package com.kasem.hr_layout.HR_Services.HRDAO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Kasemsuk Laiwtakul on 9/5/2560.
 */

public class HRDAO {
    //ต้องตรงกับชื่อ json
    @SerializedName("Skill")
    public ArrayList<Skill> skill;
}
