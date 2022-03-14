//package at.sinclothing.backend.pojos;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity(name = "address")
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
//@Data
//public class Address implements Serializable {
//
//    @Id
//    @GeneratedValue
//    private Long addressId;
//
//    @NonNull
//    private String street_name;
//    @NonNull
//    private String street_number;
//    @NonNull
//    private String city;
//    @NonNull
//    private int postal_code;
//    @NonNull
//    private String country;
//    @NonNull
//    private int door_number;
//
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//}
