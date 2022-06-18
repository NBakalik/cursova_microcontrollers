import styled from 'styled-components';

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
`

export const ButtonWrapper = styled.div`
  display: flex;
  flex-direction: row;
`

export const StateWrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin: 25px 0 25px 25px;
`

export const Button = styled.button`
  padding: 40px 50px;
  height: 150px;
  background-color: #f3f3f3;
  border: none;
  border-radius: 25px;
  margin: 25px 30px;
  font-size: 34px;
  align-self: center;

  &:hover {
    box-shadow: 0 0 8px #777676;
  }

  &:active {
    background-color: #dcdcdc;
  }
`