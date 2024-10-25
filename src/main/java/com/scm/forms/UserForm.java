
package com.scm.forms;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {
    @NotBlank(message = "please , Enter Name")
    private String name;
    @NotBlank(message = "Kindly,Enter Valid Email")
    private String email;
    @NotBlank(message = "Kindly , Enter the password")
    @Size(min = 3,max = 6)
    private String password;
    private String about;
    @Size(min = 8,max = 10,message = "Provide validate Mobile Number")
    private String phoneNumber;
}
