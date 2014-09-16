package evidencegenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Caitano Junior
 */
@Entity
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String enunciation;
    @OneToMany(mappedBy ="question", cascade= CascadeType.ALL)
    private List<Alternative> alternativesWrong;
    @OneToOne(cascade = CascadeType.ALL)
    private Alternative correctAlternative;
    
    public Alternative getCorrectAlternative() {
        return correctAlternative;
    }

    public void setCorrectAlternative(Alternative correctAlternative) {
        this.correctAlternative = correctAlternative;
        correctAlternative.setQuestion(this);
    }
    
    public void addAlternativesWrong(Alternative a){
        if(alternativesWrong == null){
            this.alternativesWrong = new ArrayList<Alternative>();
        }
        this.alternativesWrong.add(a);
        a.setQuestion(this);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEnunciation() {
        return enunciation;
    }

    public void setEnunciation(String enunciation) {
        this.enunciation = enunciation;
    }

    public List getAlternativesWrong() {
        return alternativesWrong;
    }

    public void setAlternativesWrong(List alternativesWrong) {
        this.alternativesWrong = alternativesWrong;
    }
        
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "evidencegenerator.Question[ id=" + id + " ]";
    }
    
}
