package com.zktr.crmproject.pojos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Qa {
    private int qaId;
    private String question;
    private String answer;
    private String internalPrompt;
    private String anthor;
    private Timestamp creatonTime;
    private String classification;
    private String status;

    @Id
    @Column(name = "qa_id")
    public int getQaId() {
        return qaId;
    }

    public void setQaId(int qaId) {
        this.qaId = qaId;
    }

    @Basic
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Basic
    @Column(name = "internal_prompt")
    public String getInternalPrompt() {
        return internalPrompt;
    }

    public void setInternalPrompt(String internalPrompt) {
        this.internalPrompt = internalPrompt;
    }

    @Basic
    @Column(name = "anthor")
    public String getAnthor() {
        return anthor;
    }

    public void setAnthor(String anthor) {
        this.anthor = anthor;
    }

    @Basic
    @Column(name = "creaton_time")
    public Timestamp getCreatonTime() {
        return creatonTime;
    }

    public void setCreatonTime(Timestamp creatonTime) {
        this.creatonTime = creatonTime;
    }

    @Basic
    @Column(name = "classification")
    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Qa qa = (Qa) o;
        return qaId == qa.qaId &&
                Objects.equals(question, qa.question) &&
                Objects.equals(answer, qa.answer) &&
                Objects.equals(internalPrompt, qa.internalPrompt) &&
                Objects.equals(anthor, qa.anthor) &&
                Objects.equals(creatonTime, qa.creatonTime) &&
                Objects.equals(classification, qa.classification) &&
                Objects.equals(status, qa.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qaId, question, answer, internalPrompt, anthor, creatonTime, classification, status);
    }
}
