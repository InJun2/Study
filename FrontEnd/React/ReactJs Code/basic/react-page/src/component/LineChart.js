import React from 'react';
import { ResponsiveLine } from '@nivo/line';

const LineChart = () => (
    <ResponsiveLine
        data={(testData)}
        margin={{ top: 50, right: 110, bottom: 50, left: 60 }}
        xScale={{ type: 'point' }}
        yScale={{
            type: 'linear',
            min: 'auto',
            max: 'auto',
            stacked: true,
            reverse: false
        }}
        yFormat=" >-.2f"
        axisTop={null}
        axisRight={null}
        axisBottom={{
            orient: 'bottom',
            tickSize: 5,
            tickPadding: 5,
            tickRotation: 0,
            legend: 'transportation',
            legendOffset: 36,
            legendPosition: 'middle'
        }}
        axisLeft={{
            orient: 'left',
            tickSize: 5,
            tickPadding: 5,
            tickRotation: 0,
            legend: 'count',
            legendOffset: -40,
            legendPosition: 'middle'
        }}
        lineWidth={1}
        pointSize={3}
        pointColor={{ theme: 'background' }}
        pointBorderWidth={1}
        pointBorderColor={{ from: 'serieColor' }}
        pointLabelYOffset={-12}
        useMesh={true}
        legends={[
            {
                anchor: 'bottom-right',
                direction: 'column',
                justify: false,
                translateX: 99,
                translateY: 0,
                itemsSpacing: 0,
                itemDirection: 'left-to-right',
                itemWidth: 80,
                itemHeight: 20,
                itemOpacity: 0.75,
                symbolSize: 12,
                symbolShape: 'circle',
                symbolBorderColor: 'rgba(0, 0, 0, .5)',
                effects: [
                    {
                        on: 'hover',
                        style: {
                            itemBackground: 'rgba(0, 0, 0, .03)',
                            itemOpacity: 1
                        }
                    }
                ]
            }
        ]}
        animate={false}
    />
);

export default LineChart;


const testData = 
[
    {
    "id": "japan",
    "color": "hsl(35, 70%, 50%)",
    "data": [
        {
        "x": "plane",
        "y": 162
        },
        {
        "x": "helicopter",
        "y": 24
        },
        {
        "x": "boat",
        "y": 285
        },
        {
        "x": "train",
        "y": 239
        },
        {
        "x": "subway",
        "y": 49
        },
        {
        "x": "bus",
        "y": 170
        },
        {
        "x": "car",
        "y": 285
        },
        {
        "x": "moto",
        "y": 287
        },
        {
        "x": "bicycle",
        "y": 173
        },
        {
        "x": "horse",
        "y": 280
        },
        {
        "x": "skateboard",
        "y": 118
        },
        {
        "x": "others",
        "y": 196
        }
    ]
    },
    {
    "id": "france",
    "color": "hsl(336, 70%, 50%)",
    "data": [
        {
        "x": "plane",
        "y": 64
        },
        {
        "x": "helicopter",
        "y": 186
        },
        {
        "x": "boat",
        "y": 36
        },
        {
        "x": "train",
        "y": 226
        },
        {
        "x": "subway",
        "y": 162
        },
        {
        "x": "bus",
        "y": 78
        },
        {
        "x": "car",
        "y": 194
        },
        {
        "x": "moto",
        "y": 93
        },
        {
        "x": "bicycle",
        "y": 130
        },
        {
        "x": "horse",
        "y": 217
        },
        {
        "x": "skateboard",
        "y": 208
        },
        {
        "x": "others",
        "y": 255
        }
    ]
    },
    {
    "id": "us",
    "color": "hsl(224, 70%, 50%)",
    "data": [
        {
        "x": "plane",
        "y": 225
        },
        {
        "x": "helicopter",
        "y": 220
        },
        {
        "x": "boat",
        "y": 168
        },
        {
        "x": "train",
        "y": 275
        },
        {
        "x": "subway",
        "y": 287
        },
        {
        "x": "bus",
        "y": 103
        },
        {
        "x": "car",
        "y": 31
        },
        {
        "x": "moto",
        "y": 255
        },
        {
        "x": "bicycle",
        "y": 93
        },
        {
        "x": "horse",
        "y": 45
        },
        {
        "x": "skateboard",
        "y": 88
        },
        {
        "x": "others",
        "y": 226
        }
    ]
    },
    {
    "id": "germany",
    "color": "hsl(272, 70%, 50%)",
    "data": [
        {
        "x": "plane",
        "y": 277
        },
        {
        "x": "helicopter",
        "y": 87
        },
        {
        "x": "boat",
        "y": 105
        },
        {
        "x": "train",
        "y": 37
        },
        {
        "x": "subway",
        "y": 252
        },
        {
        "x": "bus",
        "y": 278
        },
        {
        "x": "car",
        "y": 85
        },
        {
        "x": "moto",
        "y": 26
        },
        {
        "x": "bicycle",
        "y": 145
        },
        {
        "x": "horse",
        "y": 297
        },
        {
        "x": "skateboard",
        "y": 79
        },
        {
        "x": "others",
        "y": 19
        }
    ]
    },
    {
    "id": "norway",
    "color": "hsl(120, 70%, 50%)",
    "data": [
        {
        "x": "plane",
        "y": 189
        },
        {
        "x": "helicopter",
        "y": 181
        },
        {
        "x": "boat",
        "y": 282
        },
        {
        "x": "train",
        "y": 122
        },
        {
        "x": "subway",
        "y": 114
        },
        {
        "x": "bus",
        "y": 35
        },
        {
        "x": "car",
        "y": 17
        },
        {
        "x": "moto",
        "y": 162
        },
        {
        "x": "bicycle",
        "y": 288
        },
        {
        "x": "horse",
        "y": 80
        },
        {
        "x": "skateboard",
        "y": 256
        },
        {
        "x": "others",
        "y": 209
        }
    ]
    }
];