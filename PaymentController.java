@RestController
@RequestMapping("/payment")
public class PaymentController {
   
    @Autowired
    PaymentService paymentService;
 
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentService.savePayment(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent()) {
            return ResponseEntity.ok(payment.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
    Optional<Payment> existingPayment = paymentService.getPaymentById(id);
    if (existingPayment.isPresent()) {
        updatedPayment.setPaymentId(id);
        Payment savedPayment = paymentService.savePayment(updatedPayment);
        return ResponseEntity.ok(savedPayment);
    } else {
        return ResponseEntity.notFound().build();
    }
    }
 
    @DeleteMapping("/{id}")
    public void deleteowner (@PathVariable("id") Long id){
        paymentService.deleteById(id);
    }
 
    @GetMapping
    public ResponseEntity<Iterable<Payment>> getAllPayments() {
        Iterable<Payment> payments = paymentService.findAll();
        if (payments.iterator().hasNext()) {
            return ResponseEntity.ok(payments);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
   
}