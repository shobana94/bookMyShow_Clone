@Entity
@Data
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    //private Long customerId;
    @ManyToOne
    @JoinColumn(name = "id")
    private customer customer;
 
    //private String movieName;
 
    @ManyToOne
    @JoinColumn(name = "movieId")
    private owner owner;
 
    private Integer seatsRequired;
    private Integer ticketPrice;
    private Integer totalPrice;
    private String paymentStatus;
   
}
