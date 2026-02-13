import axios from 'axios'
import React, {useState} from 'react'

function SignUp () {

    const [formData, setFormData] = useState({
        email: '',
        password: '',
        nickname: '',
        phoneNumber: '',
        birthDate: '',
        profileImageUrl: 'default_profile.png',
        balance: 0,
        socialType: 'Normal'
    });

    const handleChange = (e) => {
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/api/users/sign-up', formData);

            if (response.status === 200) {
                alert('환영합니다.');
                console.log('가입된 유저 정보: ', response.data);
            }
        } catch (error) {
            console.log('실패: ', error);
            alert('회원가입 중 실패');
        }
    }

    return (
        <div style={styles.container}>
            <h2>ArtistSpace 회원가입</h2>
            <form onSubmit={handleSubmit} style={styles.form}>
                <input type="email" name="email" placeholder="이메일" onChange={handleChange} required style={styles.input} />
                <input type="password" name="password" placeholder="비밀번호" onChange={handleChange} required style={styles.input} />
                <input type="text" name="nickname" placeholder="닉네임" onChange={handleChange} required style={styles.input} />
                <input type="text" name="phoneNumber" placeholder="전화번호 (- 제외)" onChange={handleChange} style={styles.input} />
                
                <label style={styles.label}>생년월일 (미성년자 필터링을 위해 필요합니다)</label>
                <input type="date" name="birthDate" onChange={handleChange} required style={styles.input} />

                <button type="submit" style={styles.button}>가입하기</button>
            </form>
        </div>
    );
};

// 간단한 인라인 스타일
const styles = {
    container: { maxWidth: '400px', margin: '50px auto', textAlign: 'center', padding: '20px', border: '1px solid #ddd', borderRadius: '10px' },
    form: { display: 'flex', flexDirection: 'column' },
    input: { margin: '10px 0', padding: '10px', fontSize: '16px', borderRadius: '5px', border: '1px solid #ccc' },
    label: { fontSize: '12px', textAlign: 'left', color: '#666', marginTop: '10px' },
    button: { padding: '12px', backgroundColor: '#1DA1F2', color: 'white', border: 'none', borderRadius: '5px', cursor: 'pointer', fontWeight: 'bold' }
};

export default SignUp
