package com.adobe.aem.handy.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;

import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import com.day.cq.wcm.api.Page;


@Model(adaptables = SlingHttpServletRequest.class, adapters = Author.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)



public class AuthorImpl implements Author{
    
    @ScriptVariable
    Page currentPage;
    
    
    @Inject
    @Default(values = "AEM")
    
    String fname;
    
    @Inject
    String pname;
    


    @Override
    public String getFullName() {
        
      // Reverse the value of fname
      //StringBuilder reversedName = new StringBuilder(fname).reverse();
      //return reversedName.toString();

      // Capitalize only the first letter of fname
      /*if (fname != null && !fname.isEmpty()) {
        return Character.toUpperCase(fname.charAt(0)) + fname.substring(1);
    }
    return fname;*/


      // Capitalize the characters in fname
      StringBuilder capitalizedName = new StringBuilder();
      for (char c : fname.toCharArray()) {
          capitalizedName.append(Character.toUpperCase(c));
      }
      return capitalizedName.toString();
    }




    @Override
    public String getPetName() {
      // Capitalize only the first letter of fname
      if (pname != null && !pname.isEmpty()) {
        return Character.toUpperCase(pname.charAt(0)) + pname.substring(1);
      
    }return pname; 
  }



    @Override
    public String getPageTitle() {
      // Reverse the value of fname
      StringBuilder reversedName = new StringBuilder(currentPage.getTitle()).reverse();
      return reversedName.toString();
    //return currentPage.getTitle();    
    }

}
