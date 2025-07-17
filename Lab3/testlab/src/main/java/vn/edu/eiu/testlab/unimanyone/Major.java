package vn.edu.eiu.testlab.unimanyone;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_major")
public class Major {
    @Id
    @Column(name = "Id")
  private String  majorId;


    @Column(name = "Name")
    private String  majorName;


}
