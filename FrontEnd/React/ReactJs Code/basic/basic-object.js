import React, {Component} from 'react';

export default class listSet extends Component{
    render(){
        let object = {
            a: '1',
            b: '2',
            c: {
                d: '3',
                e: '4',
                f: {
                    change_this_value: '0',
                    this_stays_same: '6'
                }
            }
        }

        let changed = {
            ...object,
            c: {
                ...object.c,
                f:{
                    ...object.c.f,
                    change_this_value: '7'
                }

            }
        };

        return (
            <div>
                <h3>{JSON.stringify(changed.c)}</h3> {/* JSON.parse는 string to Object, JSON.stringfy는 JavaScript 값으나 객체를 JSON string 으로 출력 */}
            </div>
        );
    }
}
