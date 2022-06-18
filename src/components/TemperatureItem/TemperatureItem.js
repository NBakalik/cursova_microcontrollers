import {Wrapper, Label, Text, TextWrapper} from './TemperatureItem.styles'

export function TemperatureItem(props) {
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