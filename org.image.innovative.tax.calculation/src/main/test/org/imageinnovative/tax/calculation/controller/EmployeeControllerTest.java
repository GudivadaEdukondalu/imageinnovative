/*
 * import java.util.Arrays; import java.util.List;
 * 
 * import org.imageinnovative.tax.calculation.dto.Employee; import
 * org.imageinnovative.tax.calculation.dto.EmployeeTaxDeduction; import
 * org.imageinnovative.tax.calculation.service.EmployeeService; import
 * org.junit.Before; import org.junit.Test; import org.junit.runner.RunWith;
 * import org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.context.junit4.SpringRunner; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @WebMvcTest(EmployeeController.class) public class EmployeeControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private EmployeeService employeeService;
 * 
 * private Employee sampleEmployee; private List<EmployeeTaxDeduction>
 * sampleTaxDeductions;
 * 
 * @Before public void setUp() { // Initialize sample data sampleEmployee = new
 * Employee(); sampleEmployee.setEmployeeId("1");
 * sampleEmployee.setFirstName("John"); sampleEmployee.setLastName("Doe");
 * 
 * sampleTaxDeductions = Arrays.asList( new EmployeeTaxDeduction("1", "John",
 * "Doe", 50000, 2500, 100), new EmployeeTaxDeduction("2", "Jane", "Doe", 60000,
 * 3000, 120) ); }
 * 
 * @Test public void testCreateEmployee() throws Exception { // Mock the
 * behavior of the service
 * Mockito.when(employeeService.createEmployee(Mockito.any(Employee.class)))
 * .thenReturn(sampleEmployee);
 * 
 * // Perform the HTTP request
 * mockMvc.perform(MockMvcRequestBuilders.post("/api/employees/createEmployee")
 * .content(
 * "{\"employeeId\":\"1\",\"firstName\":\"John\",\"lastName\":\"Doe\"}")
 * .contentType(MediaType.APPLICATION_JSON))
 * .andExpect(MockMvcResultMatchers.status().isCreated())
 * .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value("1"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe")); }
 * 
 * @Test public void testGetEmployeeById() throws Exception { // Mock the
 * behavior of the service
 * Mockito.when(employeeService.getEmployeeById(Mockito.anyLong()))
 * .thenReturn(sampleEmployee);
 * 
 * // Perform the HTTP request
 * mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/1"))
 * .andExpect(MockMvcResultMatchers.status().isOk())
 * .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value("1"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe")); }
 * 
 * @Test public void testGetTaxDeductions() throws Exception { // Mock the
 * behavior of the service Mockito.when(employeeService.getTaxDeductions())
 * .thenReturn(sampleTaxDeductions);
 * 
 * // Perform the HTTP request
 * mockMvc.perform(MockMvcRequestBuilders.get("/api/employees/tax"))
 * .andExpect(MockMvcResultMatchers.status().isOk())
 * .andExpect(MockMvcResultMatchers.jsonPath("$[0].employeeCode").value("1"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[0].firstName").value("John"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[0].lastName").value("Doe"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[0].yearlySalary").value(50000))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[0].taxAmount").value(2500))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[0].cessAmount").value(100))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[1].employeeCode").value("2"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[1].firstName").value("Jane"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[1].lastName").value("Doe"))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[1].yearlySalary").value(60000))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[1].taxAmount").value(3000))
 * .andExpect(MockMvcResultMatchers.jsonPath("$[1].cessAmount").value(120)); } }
 */