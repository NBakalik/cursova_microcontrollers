import styled from 'styled-components';

export const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
`

export const DataWrapper = styled.div`
  background-color: #f3f3f3;
  border-radius: 25px;
  display: flex;
  flex-direction: column;
  height: 51.9vh;
  padding: 20px;
  margin-top: 20px;
  margin-left: 30px;
  width: 24vw;
`

export const DataScroll = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  overflow-y: scroll;
  overflow-x: hidden;
`
export const Text = styled.h2`
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif;
  margin: 0 10px 10px 0;
  align-self: center;
`
