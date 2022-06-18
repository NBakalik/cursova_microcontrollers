import {Wrapper, Label, Text, TextWrapper} from './HumidityItem.styles'

export function HumidityItem(props) {
    return (
        <Wrapper>
            <Label>{props.value}</Label>
            <TextWrapper>
                <Text>Date: {props.date}</Text>
                <Text>Time: {props.time}</Text>
            </TextWrapper>
        </Wrapper>
    );
}