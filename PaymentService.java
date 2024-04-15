@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
 
    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }
 
    public Optional<Payment> getPaymentById(Long id){
        return paymentRepository.findById(id);
    }
 
    public Iterable<Payment> findAll(){
        return paymentRepository.findAll();
    }
 
    public void deleteById(final Long aLong){
        paymentRepository.deleteById(aLong);
    }
 
}