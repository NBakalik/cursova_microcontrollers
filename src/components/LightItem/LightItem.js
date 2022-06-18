import {Wrapper, Label, Text, TextWrapper} from './LightItem.styles'

export function LightItem(props) {
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