package intervale.dz3.springbookdemo.API;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Mock
//    private BooksDAO bookDao;
//    @Mock
//    private Books book;
//    @Mock
//    private BooksDto booksDto;
//
//    @InjectMocks
//    private BookController bookController;

//    @Test
//    public void getAllBooks() {
//        ArrayList<Books> books = new ArrayList<>();
//        when(bookDao.getBook()).thenReturn(books);
//
//        assertEquals(new ResponseEntity("No data found.", HttpStatus.BAD_REQUEST), bookController.getBooksId(1));
//        when(books.add(book));
//        books.add(book);
//
//        assertEquals(new ResponseEntity(books, HttpStatus.OK), bookController.getBooksId(1));
//        verify(bookDao, times(1)).getBook();
//    }
//
//
//
//    @Test
//    public void getBooksId(String s) throws Exception {
//        when(bookDao.findById(1)).thenReturn(book);
//        when(bookDao.findById(2)).thenThrow(EmptyResultDataAccessException.class);
//
//        assertEquals(new ResponseEntity(book, HttpStatus.OK), bookController.getBooksId(1));
//
//        assertThrows(EmptyResultDataAccessException.class, () -> bookController.getBooksId(2));
//        mockMvc.perform(get("/book?id=2")).andExpect(status().isBadRequest()).andExpect(content().
//                string("No data found for ID."));
//        //request with invalid argument
//        mockMvc.perform(get("/book?id=-100")).andExpect(status().isForbidden()).andExpect(content().
//                string("getBookById.id: must be greater than or equal to 1"));
//
//
//    }
//    @Test
//    public void createBook() throws Exception {
//        when(bookDao.saveBooks(book)).thenReturn(1);
//        //Book added successfully
//        assertEquals(new ResponseEntity("Book added successfully.", HttpStatus.OK), bookController.createBooks(book));
//        //Empty json
//        mockMvc.perform(put("/add").content(" ")
//                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andExpect(content().
//                string("Invalid json."));
//        //Incorrect argument for book
//        mockMvc.perform(put("/add").content(new ObjectMapper().writeValueAsString(new Books(0, null, null,
//                        "A.A. Kuznez", 5, 5, 5,true))).contentType(MediaType.APPLICATION_JSON)).
//                andExpect(status().isForbidden()).andExpect(content().string("Incorrect argument to initialization."));
//    }
//
//
//
//    @Test
//    public void testDeleteBook() throws Exception {
//        when(bookDao.deleteBooksById(2)).thenReturn(2);
//        when(bookDao.deleteBooksById(2)).thenReturn(0);
//        //when book with ID is found and deleted from DB
//        assertEquals(new ResponseEntity("Book with ID = 1 deleted.", HttpStatus.OK), bookController.deleteBooks(1));
//        //when book with ID isn't foundin DB
//        assertEquals(new ResponseEntity("Book with ID = 2 doesn’t exist.", HttpStatus.BAD_REQUEST), bookController.deleteBooks(2));
//        //request with invalid argument
//        mockMvc.perform(delete("/delete?id=-100")).andExpect(status().isForbidden()).andExpect((ResultMatcher) content().
//                string("deleteBook.id: must be greater than or equal to 1"));
//    }


}