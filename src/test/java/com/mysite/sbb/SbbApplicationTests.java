package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {
	@Autowired
    private QuestionRepository questionRepository;
	
//	@Test
//    void testJpa() {        
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);  // 두번째 질문 저장
//    }
	
//	@Test
//    void testJpa() {        
//		List<Question> all = this.questionRepository.findAll();
//        assertEquals(2, all.size());
//
//        Question q = all.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
//    }
	
//	@Test
//	void testJpa() {        
//		Optional<Question> oq = this.questionRepository.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
//	}
	
//	@Test
//	void testJpa() {        
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//        assertEquals(1, q.getId());
//	}

//	@Test
//	void testJpa() {        
//		Question q = this.questionRepository.findBySubjectAndContent(
//                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//        assertEquals(1, q.getId());
//	}
	
//	@Test
//	void testJpa() {        
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question q = qList.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
//	}
	
	//데이터 수정하기
//	@Test
//	void testJpa() {        
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
//	}
	
	//데이터 삭제하기
//	@Test
//	void testJpa() {        
//		assertEquals(2, this.questionRepository.count());
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);
//        assertEquals(1, this.questionRepository.count());
//	}
	
	@Autowired
    private AnswerRepository answerRepository;
	
	//답변 데이터 생성 후 저장
//	@Test
//	void testJpa() {        
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//	}
	
	
	//질문에 달린 답변 찾기
	//세션이 만료되지 않게 하기 위하여 @Transactional 어노테이션을 사용해주어야한다.
	@Transactional
	@Test
	void testJpa() {        
		Optional<Question> oq = this.questionRepository.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        List<Answer> answerList = q.getAnswerList();

        assertEquals(1, answerList.size());
        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
}
