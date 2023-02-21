package com.bootrest.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bootrest.dao.BookRepository;
import com.bootrest.entities.Book;

@Component
public class BookService {
	@Autowired
	BookRepository bookRepository;
	//private static List<Book> list = new ArrayList<>();
	///static {
	//	list.add(new Book(2,"Python", "QWE"));
	//	list.add(new Book(3,"Java Data structures", "xyz"));
	//	list.add(new Book(4,"C# dS", "zxc"));
	//}
	
   public List<Book> getAllBooks(){
	   List<Book> list = (List<Book>)this.bookRepository.findAll();
	   return list;
   }
   
   public Book getBookById(int id) {
	   Book book= null;
	   
	   //book= list.stream().filter(e->e.getId()==id).findFirst().get();
	   book= this.bookRepository.findById(id);
	   return book;
   }
   
   public Book addBook(Book b) {
	   Book result= bookRepository.save(b);
	   return b;
   }
   
   public void deleteBook(int bid) {
	   bookRepository.deleteById(bid);
	  // list= list.stream().filter(book->{
		//   if(book.getId()!=bid) {
		//	   return true;
		//   }
		//	   else {
		//		   return false;
		//	   }
	  // }).collect(Collectors.toList());
	   
	   //list.stream().filter(book->book.getId()!==bid).collect(Collectors.toList());
   }

public void updateBook(Book book, int bid) {
	book.setId(bid);
	bookRepository.save(book);
	
	//list= list.stream().map(b->{
	//	if(b.getId()==bid) {
	//		b.setAuthor(book.getAuthor());
	//		b.setTitle(book.getTitle());
	//	}
	//	return b;
	//}).collect(Collectors.toList());
	
}
}
