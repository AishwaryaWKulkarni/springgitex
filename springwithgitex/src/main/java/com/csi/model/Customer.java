package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Pattern(regexp = "[A-Za-z]*", message = "CustName should not contain space or special characters")
    private String custName;

    @NotNull
    private String custAddress;

    @Column(unique = true)
    @Range(min = 1000000000, max = 9999999999L, message = "ContactNo must be 10 digit")
    private long custContactNo;

    private double custAccBalance;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custDOB;

    @Email(message = "Email Id must be valid")
    @Column(unique = true)
    private String custEmailId;

    @Size(min = 4, message = "Password atleast of 4 characters")
    private String custPassword;
}
