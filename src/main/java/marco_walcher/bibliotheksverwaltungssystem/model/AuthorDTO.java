package marco_walcher.bibliotheksverwaltungssystem.model;

import java.sql.Date;

public class AuthorDTO {
    
    //region <Properties>
    private String FirstName = null;
    private String LastName = null;
    private Date Birthdate = null;
    private String PlaceOfBirth = null;
    //endregion
    
    //region <Constructor>
    public AuthorDTO(String firstname, String lastname, Date birthdate, String placeofbirth) {
        this.FirstName = firstname;
        this.LastName = lastname;
        this.Birthdate = birthdate;
        this.PlaceOfBirth = placeofbirth;
    }
    //endregion
    
    //region <Getter>
    public String getFirstName() {
        return this.FirstName;
    }
    
    public String getLastName() {
        return this.LastName;
    }
    
    public Date getBirthdate() {
        return this.Birthdate;
    }
    
    public String getPlaceOfBirth() {
        return this.PlaceOfBirth;
    }
    //enregion
}
